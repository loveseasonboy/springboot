package kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

public class consumerDemo_1 {
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
        consumer.subscribe(Arrays.asList("cluster"), new ConsumerRebalanceListener() {

            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                partitions.forEach(topicPartition -> {
                    System.err.printf("revoked partition for client %s : %s-%s %n", clientId, topicPartition.topic(), topicPartition.partition());
                });
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
                partitions.forEach(topicPartition -> {
                    System.err.printf("revoked partition for client %s : %s-%s %n", clientId, topicPartition.topic(), topicPartition.partition());
                });
            }
        });//必须要订阅一下  自动分配的partition
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            records.forEach(record -> {
                System.err.printf("client: %s , topic: %s , partition: %d , offset : %d , key = %s, value = %s%n",
                        clientId, record.topic(), record.partition(), record.offset(), record.key(), record.value());
            });
        }
    }
}
