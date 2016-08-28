package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xxh on 2016/8/28.
 */
public class MyBatisSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory == null){
            InputStream inputStream;
            try{
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return sqlSessionFactory;
    }
    public static SqlSession openSession(){
        return getSqlSessionFactory().openSession();
    }
}
