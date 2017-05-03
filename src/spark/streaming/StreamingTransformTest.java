package spark.streaming;

import com.google.common.collect.Lists;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by xinghailong on 2017/4/18.
 */
public class StreamingTransformTest {

    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("StreamingTransformTest");
        JavaStreamingContext ssc = new JavaStreamingContext(conf, Durations.seconds(10));

        JavaReceiverInputDStream<String> lines = ssc.socketTextStream("10.10.5.102",12345, StorageLevel.MEMORY_AND_DISK_SER_2());

        List<Tuple2<String, Integer>> tuples = Arrays.asList(new Tuple2<>("hello", 1),new Tuple2<>("world", 1));
        JavaPairRDD<String, Integer> initialRDD = ssc.sparkContext().parallelizePairs(tuples);

        JavaDStream<String> words = lines.flatMap(x -> Lists.newArrayList(SPACE.split(x)));

//        words.transform()
    }
}
