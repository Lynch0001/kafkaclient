package com.example.kafkademo;

import org.apache.camel.spring.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


class CamelreadydemoApplicationTests {

    public static void main(String[] args) throws Exception {
        System.out.println("STARTING CamelReady Test Application");
        Logger log = LogManager.getLogger(KafkaClientDemoApplication.class);
        log.debug("Starting Test App");
        Main main = new Main();
        main.setApplicationContextUri("CamelContext.xml");
        main.run();
        log.info("Test App Started:");
    }

}
