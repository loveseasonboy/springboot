package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

/**
 * kafka 每一个partitons 对应一个consumer ，也可以是对应group
 * 1、partition 可以手动配置
 * 2、consumer 的手动提交可能产生数据的延迟
 *
 */
public class consumerDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", producterDome.host);
        props.put("group.id", "test");
        //props.put("enable.auto.commit", "true");//自动提交,采用的是poll的方式
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("metrics.log.level", "info");

        props.put("offsets.storage","kafka");//将offset存于kafka和zookeeper中
        props.put("dual.commit.enabled","true");//只有这个设置为true才会生效

        KafkaConsumer consumer = new KafkaConsumer(props);
        //consumer.subscribe(Arrays.asList("cluster"));//必须要订阅一下  自动分配的partition
        TopicPartition topicPartition = new TopicPartition("cluster", 0);//手动分配partition
        consumer.assign(Arrays.asList(topicPartition));
        int minBatchSize = 50;
        List<ConsumerRecord<String, String>> buff = new ArrayList<>();
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(1000);
//            for (ConsumerRecord<String, String> record : records) {
//                buff.add(record);
//                //System.err.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            }
//            if (buff.size() >= minBatchSize) {//手动提交会导致数据的延迟
//                //处理数据
//                insertIntoDb(buff);
//                //consumer.commitSync();
//                buff.clear();
//            }
//
//        }
        //获取offset数据的偏移量
        ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
        for (TopicPartition partition : records.partitions()) {
            List<ConsumerRecord<String, String>> recordsPatitions = records.records(partition);
            for (ConsumerRecord<String, String> record : recordsPatitions) {
                System.err.println(record.offset() + ":" + record.value());
            }
            long lastoffset = recordsPatitions.get(recordsPatitions.size() - 1).offset();
            consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastoffset + 1)));
        }
        consumer.close();
    }

    public static void insertIntoDb(List<ConsumerRecord<String, String>> records) {
        for (ConsumerRecord<String, String> record : records) {
            System.err.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }
}
