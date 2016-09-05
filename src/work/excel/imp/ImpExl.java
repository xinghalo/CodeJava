import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 把excel数据导入数据库中
 */
public class ImpExl {

    public static void main(String[] args){
        Connection conn = null;
        String sql;

        XSSFWorkbook wb = null;
        POIFSFileSystem fs = null;

        try {
            //连接mysql数据库
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://10.10.1.240:3306/standford", "lilei", "lilei123@");
            System.out.println("Database connection established");

            //读取excel内容
            InputStream stream = new FileInputStream("D:\\Backup\\Documents\\Tencent Files\\23603357\\FileRecv\\【上游页面】埋点规范_A10_20160831.xlsx");
            wb=new XSSFWorkbook(stream);

            PreparedStatement sta=null;
            String foreign_key="";//b表外键

            Sheet sheet1 = wb.getSheetAt(1);
            for(int i=2,total = sheet1.getLastRowNum();i<total;i++){
                Row row = sheet1.getRow(i);

                if(row.getCell(7) == null || row.getCell(7).toString().equals("")) continue;//遇到空行直接跳过

                //通过编码以及名称确定b表中的id
                if(row.getCell(3) != null){
                    sql = "select id from scp_b where name=? and code=?";
                    sta = conn.prepareStatement(sql);
                    sta.setString(1, row.getCell(3).toString());
                    sta.setString(2, row.getCell(4).toString());
                    ResultSet rs = sta.executeQuery();
                    while(rs.next()){
                        foreign_key=rs.getString("id");
                    }
                    sta.close();
                }

                //删除c表中已经存在的数据
                sql="delete from scp_c where id=?";
                sta = conn.prepareStatement(sql);
                sta.setInt(1,i-2);
                sta.execute();
                System.out.println("删除id="+(i-2)+"数据");

                //插入数据
                sql="insert into scp_c(id,code,name,code_rule,bk,web,ios,android,description,bury_time,update_time,create_time,modify_time,fk_scp_b_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                sta = conn.prepareStatement(sql);
                sta.setInt(1,i-2);//主键
                sta.setString(2,row.getCell(7).toString());//编码
                sta.setString(3,row.getCell(6).toString());//名称
                sta.setString(4,row.getCell(8).toString());//编码说明
                sta.setString(5,row.getCell(9).toString());//bk
                sta.setInt(6,row.getCell(10)==null?0:(row.getCell(10).toString().equals("")?0:1));//web上是否包含该点
                sta.setInt(7,row.getCell(11)==null?0:(row.getCell(11).toString().equals("")?0:1));//ios上是否包含改点
                sta.setInt(8,row.getCell(12)==null?0:(row.getCell(12).toString().equals("")?0:1));//android上是否包含该点位
                sta.setString(9,row.getCell(13)==null?null:row.getCell(13).toString());//备注信息

                //时间字段转换
                sta.setDate(10,getSQLDate(row.getCell(14).toString()));//埋点时间
                sta.setDate(11,getSQLDate2(row.getCell(15).toString()));//修改时间
                sta.setDate(12,null);
                sta.setDate(13,null);

                sta.setInt(14,new Integer(foreign_key));//指向b的外键
                sta.execute();
                System.out.println("插入id="+(i-2)+"数据");

                sta.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static java.sql.Date getSQLDate2(String format){
        return null;
        /*if(format == null || format.equals("")) return null;
        SimpleDateFormat sp = new SimpleDateFormat("yyyyMMdd");
        java.util.Date d = null;
        try {
            d = sp.parse(format);
            java.sql.Date date = new java.sql.Date(d.getTime());
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }*/
    }
    /**
     * 20-七月-2016
     */
    public static java.sql.Date getSQLDate(String format){
        if(format == null) return null;
        Pattern pattern = Pattern.compile("[\\d]+-[\\u4e00-\\u9fa5]+-[\\d]+");
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");

        Matcher matcher = pattern.matcher(format);
        if (matcher.find()){
            System.out.println("找到date"+format);
            String[] args = format.split("-");
            java.util.Date d = null;
            try {
                d = sp.parse(args[2]+"-"+Zh2Int(args[1])+"-"+args[0]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date date = new java.sql.Date(d.getTime());
            return date;
        }
        return null;
    }
    public static String Zh2Int(String zh){
        if(zh.equals("一月")){
            return "01";
        }else if(zh.equals("二月")){
            return "02";
        }else if(zh.equals("三月")){
            return "03";
        }else if(zh.equals("四月")){
            return "04";
        }else if(zh.equals("五月")){
            return "05";
        }else if(zh.equals("六月")){
            return "06";
        }else if(zh.equals("七月")){
            return "07";
        }else if(zh.equals("八月")){
            return "08";
        }else if(zh.equals("九月")){
            return "09";
        }else if(zh.equals("十月")){
            return "10";
        }else if(zh.equals("十一月")){
            return "11";
        }else{
            return "12";
        }
    }
}
