package kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import scala.Tuple2;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xinghailong on 2017/5/3.
 */
public class KafkaTest extends Thread{
    /**
     * 人的信息
     */
    static List<Tuple2<Integer,String>> userInfos;

    /**
     * 广告的信息
     */
    static List<Tuple2<Integer,String>> adInfos;

    /**
     * 行为的信息
     */
    static List<Tuple2<String,Integer>> actionInfos;

    static{
        userInfos = new ArrayList<Tuple2<Integer,String>>();
        userInfos.add(new Tuple2<Integer,String>(10001,"高鹏"));
        userInfos.add(new Tuple2<Integer,String>(10002,"李思剑"));
        userInfos.add(new Tuple2<Integer,String>(10003,"叶艳"));
        userInfos.add(new Tuple2<Integer,String>(10004,"李银"));
        userInfos.add(new Tuple2<Integer,String>(10005,"杨凌然"));
        userInfos.add(new Tuple2<Integer,String>(10006,"李磊"));
        userInfos.add(new Tuple2<Integer,String>(10007,"杨蜜"));
        userInfos.add(new Tuple2<Integer,String>(10008,"邢海龙"));
        userInfos.add(new Tuple2<Integer,String>(10009,"孙军"));
        userInfos.add(new Tuple2<Integer,String>(10010,"杨孝华"));

        adInfos = new ArrayList<Tuple2<Integer,String>>();
        adInfos.add(new Tuple2<Integer,String>(20001,"会员尊享"));
        adInfos.add(new Tuple2<Integer,String>(20002,"环球精选"));
        adInfos.add(new Tuple2<Integer,String>(20003,"海外直邮"));
        adInfos.add(new Tuple2<Integer,String>(20004,"跨境导航"));
        adInfos.add(new Tuple2<Integer,String>(20005,"新发现"));
        adInfos.add(new Tuple2<Integer,String>(20006,"品牌闪购"));
        adInfos.add(new Tuple2<Integer,String>(20007,"城市惠"));
        adInfos.add(new Tuple2<Integer,String>(20008,"虚拟货架"));
        adInfos.add(new Tuple2<Integer,String>(20009,"撒娇礼"));
        adInfos.add(new Tuple2<Integer,String>(20010,"友好易购"));

        actionInfos = new ArrayList<Tuple2<String,Integer>>();
        actionInfos.add(new Tuple2<String,Integer>("View",1));
        actionInfos.add(new Tuple2<String,Integer>("Click",5));
        actionInfos.add(new Tuple2<String,Integer>("Appraise",10));
    }


    /**
     * 对应的 Kafka主题
     */
    private String topic;

    Producer<Integer, String> producerForKafka;

    private static String today ;

    private static Random random ;

    public KafkaTest(String topic) {
        this.topic = topic;
        random = new Random();
        today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Properties conf = new Properties();
        conf.put("metadata.broker.list", "localnod2:9092,localnode4:9092");
        conf.put("serializer.class", "kafka.serializer.StringEncoder");
        producerForKafka = new Producer<Integer, String>(new ProducerConfig(conf));
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            counter++;
            String adLog = adLogs(100);
            System.out.println("produce:" + adLog);
            producerForKafka.send(new KeyedMessage<Integer, String>(topic,adLog));
            if (counter % 100 == 0) {
                counter = 0;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成 userlog记录
     */
    private static String adLogs(long numberItems){
        StringBuffer adLogBuf = new StringBuffer("");
//           int[] unregisterdUsers = new int[]{1,2,3,4,5,6,7,8};  //未注册的用户
        for(int i = 0; i < numberItems ;i ++){

            Long timestamp = new Date().getTime();

            //随机生成用户信息
            Tuple2<Integer, String> userInfo= userInfos.get(random.nextInt(10));
            Integer userID = userInfo._1;
            String userName = userInfo._2;
            //随机生成广告信息
            Tuple2<Integer, String> adInfo = adInfos.get(random.nextInt(10));
            Integer adID = adInfo._1;
            String adName = adInfo._2;
            //随机生成动作信息
            Tuple2<String, Integer> actionInfo = actionInfos.get(random.nextInt(3));
            String actionName = actionInfo._1;
            Integer actionScore = actionInfo._2;

            //随机生成location
            String location = generateLocation();

            adLogBuf.append(userID)
                    .append(",")
//		              .append(today)
//                      .append(",")
                    .append(userName)
                    .append(",")
                    .append(adID)
                    .append(",")
                    .append(adName)
                    .append(",")
                    .append(actionName)
                    .append(",")
                    .append(actionScore)
                    .append(",")
                    .append(timestamp)
                    .append(",")
                    .append(location)
                    .append(",")
                    .append("END")
                    .append("\n");

        }
        return adLogBuf .toString();

    }

    public static String generateLocation(){
        Integer lat = null;
        Integer lng = null;
        int r = random.nextInt(7);
        if(r % 3 == 0){
            lat = 30 + random.nextInt(5);
            lng = 130 + random.nextInt(5);
        }
        if(r % 3 == 1){
            lat = 40 + random.nextInt(5);
            lng = 110 + random.nextInt(5);
        }
        if(r % 3 == 2){
            lat = 30 + random.nextInt(5);
            lng = 120 + random.nextInt(5);
        }
        return lat.toString()+"_"+lng.toString();

    }

    public static void main(String[] args) {
        //指定topic为zdw_topic
        new KafkaTest("xhl_topic" ).start();
    }
}
