package kafka;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

public class consumerDemo_assign {
    public static void main(String[] args) {
        String clientId = "521";
        Properties props = new Properties();
        props.put("bootstrap.servers", producterDome.host);
        props.put("group.id", "test");
        props.put("client.id", clientId);
        props.put("enable.auto.commit", "true");//自动提交,采用的是poll的方式
        //props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //props.put("offsets.storage","kafka");//将offset存于kafka和zookeeper中
        //props.put("dual.commit.enabled","true");//只有这个设置为true才会生效

        KafkaConsumer consumer = new KafkaConsumer(props);
        consumer.assign(Arrays.asList(new TopicPartition("cluster", 0), new TopicPartition("cluster", 1)));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            records.forEach(record -> {
                System.err.printf("client : %s , topic: %s , partition:%d ,offset = %d, key = %s, value = %s%n", clientId, record.topic(), record.partition(), record.offset(), record.key(), record.value());
            });
        }
    }
}
