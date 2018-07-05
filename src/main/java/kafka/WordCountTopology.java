package kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.TopologyBuilder;

import java.util.Properties;

public class WordCountTopology {
    public static void main(String[] args) {
        Properties props =new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG,"streams-wordcount-processor");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,producterDome.host);
        props.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG,"192.168.179.128:2181");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.Integer().getClass());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        TopologyBuilder builder =new TopologyBuilder();

    }
}
