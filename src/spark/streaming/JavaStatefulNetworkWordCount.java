package spark.streaming;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.api.java.function.Function3;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.State;
import org.apache.spark.streaming.StateSpec;
import org.apache.spark.streaming.api.java.*;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 基于检查点计算状态
 *
 * Created by xinghailong on 2017/4/18.
 */
public class JavaStatefulNetworkWordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) {
        //修改日志
        if (!Logger.getRootLogger().getAllAppenders().hasMoreElements()) {
            Logger.getRootLogger().setLevel(Level.WARN);
        }

        SparkConf sparkConf = new SparkConf().setMaster("local[2]").setAppName("JavaStatefulNetworkWordCount");
        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(10));
        // TODO 检查点，如果没有连接hdfs是保存在本地？？？
        ssc.checkpoint(".");

        // 初始化key值，这个地方也可以是空的
        List<Tuple2<String, Integer>> tuples = Arrays.asList(new Tuple2<>("hello", 1),new Tuple2<>("world", 1));
        // TODO 为什么要使用paramlizePairs
        JavaPairRDD<String, Integer> initialRDD = ssc.sparkContext().parallelizePairs(tuples);
        // TODO 接收的信息保存机制是什么？
        JavaReceiverInputDStream<String> lines = ssc.socketTextStream("10.10.5.102", 12345, StorageLevels.MEMORY_AND_DISK_SER_2);

        JavaDStream<String> words = lines.flatMap(x -> Lists.newArrayList(SPACE.split(x)));
        JavaPairDStream<String, Integer> wordsDstream = words.mapToPair(s -> new Tuple2<>(s, 1));

        // 创建更新函数，该函数可以基于存储的值
        final Function3<String, Optional<Integer>, State<Integer>, Tuple2<String, Integer>> mappingFunc =(word,one,state) -> {
            int sum = one.or(0) + (state.exists() ? state.get() : 0);
            Tuple2<String, Integer> output = new Tuple2<>(word, sum);
            state.update(sum);
            return output;
        };

        // DStream made of get cumulative counts that get updated in every batch
        // DStream里面只能返回当前stream窗口的数据
        JavaMapWithStateDStream<String, Integer, Integer, Tuple2<String, Integer>> stateDstream =
                wordsDstream.mapWithState(StateSpec.function(mappingFunc).initialState(initialRDD));

        stateDstream.print();
        ssc.start();
        ssc.awaitTermination();
    }
}
