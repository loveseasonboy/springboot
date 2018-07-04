package zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class AuthSample {
    public static void main(String[] args) {
        String path = "/auth_zk";
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.179.128:2181", 2000, null);
            zooKeeper.addAuthInfo("digest", "foo:true".getBytes());
            zooKeeper.create(path, "123".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
            ZooKeeper zooKeeper1 = new ZooKeeper("192.168.179.128:2181", 2000, null);
            zooKeeper1.getData(path, false, null);
            zooKeeper.delete(path, 0);//同一个链接权限 可以操作。
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
