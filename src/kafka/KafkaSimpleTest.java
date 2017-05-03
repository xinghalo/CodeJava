package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by xinghailong on 2017/5/3.
 */
public class KafkaSimpleTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","localnode2:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> producer = new KafkaProducer<>(props);

        ProducerRecord<String,String> record = new ProducerRecord<>("xingoo_test1", "a_key", "a_value");
        try {
            //第一种方式：忽略返回的结果，只管客户端自己发
            producer.send(record);
            //第二种方式：同步发送数据
            producer.send(record).get();
            //第三种方式：异步处理
            producer.send(record,(recordMetadata,exception)->{
                exception.printStackTrace();
            });

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
