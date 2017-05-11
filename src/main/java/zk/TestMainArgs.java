package zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhoubo on 2017/5/4.
 */
public class TestMainArgs {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        for (String s : args) {
            System.out.println(s);
        }
        ZooKeeper zooKeeper = new ZooKeeper("10.8.9.184:2181", 3000, new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("已经触发 " + event.getType() + " 事件");
            }
        });
//        zooKeeper.create("/zk_test/zk_child_test", "java text".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        zooKeeper.create("/zk_test/zk_child_test/zk_grandson", "grandson".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(new String(zooKeeper.getData("/zk_test/zk_child_test", true,null)));

        List<String> childrens = zooKeeper.getChildren("/zk_test/zk_child_test", true);
        for (String s : childrens) {
            System.out.println(s);
        }

//        zooKeeper.delete("/zk_test/zk_child_test1", -1);
        Stat exists = zooKeeper.exists("/zk_test/zk_child_test", true);
//        System.out.println(exists.)
//        zooKeeper.

    }
}
