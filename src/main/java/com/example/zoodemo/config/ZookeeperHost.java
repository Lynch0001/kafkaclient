package com.example.kafkademo.config;

import org.apache.kafkakeeper.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

@Component
public class kafkakeeperHost {

    private kafkaKeeper zk;

    CountDownLatch connectionLatch = new CountDownLatch(1);

    public kafkakeeperHost() {
    }
    public kafkaKeeper connect(String host)
            throws IOException,
            InterruptedException {
        zk = new kafkaKeeper(host, 2000, new Watcher() {
            public void process(WatchedEvent we) {
                if (we.getState() == Event.KeeperState.SyncConnected) {
                    connectionLatch.countDown();
                }
            }
        });

        connectionLatch.await();
        return zk;
    }

    public Object getZNodeData(String path, boolean watchFlag)
            throws KeeperException,
            InterruptedException, UnsupportedEncodingException {

        byte[] b = null;
        b = zk.getData(path, null, null);
        return new String(b, "UTF-8");
    }

    public void create(String path, byte[] data)
            throws KeeperException,
            InterruptedException {

        zk.create(
                path,
                data,
                kafkaDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
    }

    public void close() throws InterruptedException {
        zk.close();
    }
}
