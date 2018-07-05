package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class producterDome {
    public static final String host = "192.168.179.128:9092,192.168.179.128:9093,192.168.179.128:9094";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", host);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
//            producer.send(new ProducerRecord<>("cluster", Integer.toString(i), "hello world" + Integer.toString(i)));
            producer.send(new ProducerRecord<>("cluster", Integer.toString(i), "hello world" + Integer.toString(i)), (metadata, exception) -> {
                if (metadata != null) {
                    System.err.printf("Send record partition:%d,offset:%d,keySize:%d,valueSize:%d %n", metadata.partition(), metadata.offset(), metadata.serializedKeySize(), metadata.serializedValueSize());
                }
                if (exception != null) {
                    exception.printStackTrace();
                }
            });
        }
        producer.close();
    }
}
