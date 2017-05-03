package spark.streaming;

import com.google.common.collect.Lists;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.regex.Pattern;

/**
 * Created by xinghailong on 2017/4/19.
 */
public class SparkStreamingWindowTest1 {

    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) {
        //修改日志
        if (!Logger.getRootLogger().getAllAppenders().hasMoreElements()) {
            Logger.getRootLogger().setLevel(Level.WARN);
        }

        SparkConf sparkConf = new SparkConf().setMaster("local[2]").setAppName("JavaStatefulNetworkWordCount");
        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(10));

        JavaReceiverInputDStream<String> lines = ssc.socketTextStream("10.10.5.102", 12345);
        JavaDStream<String> words = lines.flatMap(x -> Lists.newArrayList(SPACE.split(x)));
        JavaPairDStream<String, Integer> wordsDstream = words.mapToPair(s -> new Tuple2<>(s, 1));
        JavaPairDStream<String, Integer> stateDstream = wordsDstream.reduceByKeyAndWindow((a,b)->a+b,Durations.seconds(30),Durations.seconds(10));

        stateDstream.print();
        ssc.start();
        ssc.awaitTermination();
    }
}
