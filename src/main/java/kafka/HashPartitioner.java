package kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * 分区的一种算法
 */
public class HashPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        if ((key instanceof Integer)) {
            return Math.abs(Integer.parseInt(key.toString())) % cluster.nodes().size();
        }
        return Math.abs(key.hashCode() % cluster.nodes().size());
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
