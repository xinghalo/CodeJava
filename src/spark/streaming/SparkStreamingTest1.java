package spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.*;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by xinghailong on 2017/4/17.
 */
public class SparkStreamingTest1 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(10));

        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("10.10.5.102", 12345);

        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")));

        // Count each word in each batch
        JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2<>(s,1));
        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((a,b) -> a+b);
        // Print the first ten elements of each RDD generated in this DStream to the console
        wordCounts.print();

        jssc.start();              // Start the computation
        jssc.awaitTermination();   // Wait for the computation to terminate
    }
}
