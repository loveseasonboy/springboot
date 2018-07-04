package zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class zkDelete {
    public static void main(String[] args) {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper("192.168.179.128:2181", 1000, new zkSimpleWatcher());
            System.out.println(zk.getState());
            String s = zk.create("/java_zk_del", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("创建成功" + s);
            //Thread.sleep(2000L);
            //zk.delete("/java_zk_del",1);
            zk.delete("/java_zk_del", 0, (rc, path, ctx) -> {
                System.out.println("异步删除：" + rc + "," + path + "," + ctx);
            }, null);

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
