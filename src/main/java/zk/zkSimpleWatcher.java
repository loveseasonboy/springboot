package zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

public class zkSimpleWatcher implements Watcher {

    private static CountDownLatch countDownLatch =new CountDownLatch(1);
    @Override
    public void process(WatchedEvent event) {
        System.out.println("监听事件：" + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }
}
