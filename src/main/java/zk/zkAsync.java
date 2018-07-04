package zk;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class zkAsync {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zk = null;

    public static void main(String[] args) {
        String path = "/zk-book";
        try {
            zk = new ZooKeeper("192.168.179.128:2181", 2000, (event) -> {
                if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                    countDownLatch.countDown();
                } else if (event.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
                    try {
                        System.out.println("reget child:" + zk.getChildren(event.getPath(), true));
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("连接状态" + zk.getState());
            countDownLatch.await();

            String node = zk.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("创建成功：" + node);

            String nodeChlidren = zk.create(path + "/c1", "456".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("success:" + nodeChlidren);

            zk.getChildren(path, true, (rc, paths, ctx, c, stat) -> {
                System.out.println("Get Children znode result: [response code: " + rc + ", param path: " + paths + ", ctx: "
                        + ctx + ", children list: " + c + ", stat: " + stat);
            }, null);

            String s = zk.create(path + "/c2", "789".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("success:" + s);

            Thread.sleep(2000);//保持链接-一旦断开session就会删除临时的节点
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
