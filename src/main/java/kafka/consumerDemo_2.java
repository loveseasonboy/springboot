package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

public class consumerDemo_2 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", producterDome.host);
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");//自动提交,采用的是poll的方式
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer consumer = new KafkaConsumer(props);
        consumer.subscribe(Arrays.asList("cluster"));//必须要订阅一下  自动分配的partition

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            consumer.pause(Arrays.asList(new TopicPartition("cluster", 0)));//取消消费partition 0的数据
            consumer.pause(Arrays.asList(new TopicPartition("cluster", 1)));//取消消费partition 1的数据
            consumer.pause(Arrays.asList(new TopicPartition("cluster", 2)));//取消消费partition 2的数据
            consumer.pause(Arrays.asList(new TopicPartition("cluster", 3)));//取消消费partition 3的数据
            consumer.resume(Arrays.asList(new TopicPartition("cluster", 1)));//回复消费partition 1的数据
            for (ConsumerRecord<String, String> record : records) {
                System.err.printf("topic: %s , partition: %s , offset = %d, key = %s, value = %s%n",
                        record.topic(), record.partition(), record.offset(), record.key(), record.value());
            }
        }
    }
}
