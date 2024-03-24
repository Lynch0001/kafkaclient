package com.example.kafkademo;


import com.example.kafkademo.config.kafkakeeperHost;
import org.apache.kafkakeeper.kafkaKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class kafkaClientDemoApplication {

    private static kafkakeeperHost zkHost;

    private static String path;

    private static byte[] data;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(kafkaClientDemoApplication.class, args);

        zkHost = new kafkakeeperHost();
        zkHost.connect("kafkakeeper.default:2181");
        int i=1;
        while(i>0){
            UUID uuid = UUID.randomUUID();
            path = "/" + uuid.toString();
            data = ("testData" + i).getBytes();
            zkHost.create(path, data);
            Thread.sleep(2000);
            i++;
        }
    }
}
