package spark.streaming;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by xinghailong on 2017/4/21.
 */
public class SparkStreamingFileTest {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);
        String str = "{\"date\":\"2016-04-17 00:00:00\"}";
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList(new String[]{str}));
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD<DateBean> rdd1 = rdd.map(s -> JSON.parseObject(s,DateBean.class));
        DataFrame df = sqlContext.createDataFrame(rdd1,DateBean.class);
        Date a = df.first().getDate(0);
        System.out.println(a);
        System.out.println(df.toJSON().toJavaRDD().map(JSON::parseObject).first().getDate("date"));



        /*sc.setLogLevel("WARN");
        JSONObject jo = JSON.parseObject("{\"store_id\":\"5\",\"store_code\":\"1044\",\"new_je\":982,\"old_bs\":0,\"marketing_accurate_id\":\"1305\",\"end_time\":\"2017-04-16\",\"new_bs\":2,\"loss_tag\":\"0\",\"start_time\":\"2017-04-14\",\"new_pps\":\"008835,009002\",\"phone\":\"18945611699\",\"old_pps\":\"\",\"loss_start_time\":\"2016/10/16\",\"old_je\":0,\"cid\":\"10440000000000218637\"}");

        JavaRDD<JSONObject> rdd = sc.parallelize(Arrays.asList(new JSONObject[]{jo}),1);

        rdd =  rdd.groupBy(json -> json.getString("store_code")+"_"+json.getString("marketing_accurate_id")+"_"+json.getString("phone"))      //由于一个电话号可能对应多个cid，因此需要在这里进行重新分组计算
                .map(t2 -> {
                    JSONObject phone_person = t2._2.iterator().next();

                    String loss_tag = "1";

                    Integer new_bs = 0, old_bs = 0;
                    BigDecimal new_je = BigDecimal.ZERO,old_je = BigDecimal.ZERO;

                    Set<String> new_ppbm_set = new HashSet<>();
                    Set<String> old_ppbm_set = new HashSet<>();

                    for(JSONObject cid_person : t2._2){
                        new_bs = new_bs + cid_person.getInteger("new_bs");
                        old_bs = old_bs + cid_person.getInteger("old_bs");

                        new_je = new_je.add(cid_person.getBigDecimal("new_je"));
                        old_je = old_je.add(cid_person.getBigDecimal("old_je"));

                        if(!"".equals(cid_person.getString("new_pps"))){
                            new_ppbm_set.addAll(Arrays.asList(cid_person.getString("new_pps").split(",")));
                        }
                        if(!"".equals(cid_person.getString("old_pps"))){
                            old_ppbm_set.addAll(Arrays.asList(cid_person.getString("old_pps").split(",")));
                        }
                        if("0".equals(cid_person.getString("loss_tag"))){
                            loss_tag = "0";
                        }
                    }

                    phone_person.put("loss_tag",loss_tag);                                              //流失标记

                    phone_person.put("new_bs",new_bs);                                                  //本期笔数
                    phone_person.put("old_bs",old_bs);                                                  //同期笔数
                    phone_person.put("increment_normal_bs",new_bs-old_bs);                              //本同期笔数增长

                    phone_person.put("new_je",new_je);                                                  //本期金额
                    phone_person.put("old_je",old_je);                                                  //同期金额
                    phone_person.put("increment_normal_je",new_je.subtract(old_je));                    //本同期金额增长

                    phone_person.put("new_pps",new_ppbm_set.size());                                    //本期品牌数
                    phone_person.put("old_pps",old_ppbm_set.size());                                    //同期品牌数
                    phone_person.put("increment_normal_pps",new_ppbm_set.size()-old_ppbm_set.size());   //本同期品牌增长

                    return phone_person;
                });

        for(JSONObject i : rdd.collect()){
            System.out.println(i.toJSONString());
        }*/

    }
}
