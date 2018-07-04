package zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * 临时节点-session关闭就删除
 */
public class zkClient {
    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper("192.168.179.128:2181", 1000, new zkSimpleWatcher());
            System.out.println(zk.getState());
//            List<String> children = zk.getChildren("/brokers", true);
//            for (String name : children) {
//                System.out.println("子节点名称：" + name);
//            }
            //同步创建节点
//            System.out.println("-------------同步创建节点-----------------");
            String path_1 = zk.create("/javaApi_create_0", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("创建成功：" + path_1);
//            String path_2 = zk.create("/javaApi_create_0", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
//            System.out.println("创建成功：" + path_2);
            System.out.println("-----------------异步创建节点------------------------");
            zk.create("/javaApi_sync", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new IStringCallback(), "I am context.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
