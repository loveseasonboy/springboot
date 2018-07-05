package kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

/**
 * 分区的一种算法
 */
public class HashPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        if (keyBytes != null) {
            int hashCode;
            if (key instanceof Integer || key instanceof Long) {
                hashCode = (int) key;
            } else {
                hashCode = key.hashCode();
            }
            hashCode = hashCode & 0x7fffffff;
            return hashCode % numPartitions;
        } else {
            return 0;
        }
//        if ((key instanceof Integer)) {
//            return Math.abs(Integer.parseInt(key.toString())) % cluster.nodes().size();
//        }
//        return Math.abs(key.hashCode() % cluster.nodes().size());
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
