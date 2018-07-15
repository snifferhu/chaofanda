package com.cfd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth snifferhu
 * @date 2018/7/15 10:13
 */
@EnableEurekaServer
@SpringBootApplication
@RestController
public class EurekaServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(EurekaServiceApplication.class);

    public static void main(String[] args) {
        logger.debug("EurekaServiceApplication start...");
        Long timestamp = System.currentTimeMillis();
        SpringApplication.run(EurekaServiceApplication.class, args);
        logger.debug("EurekaServiceApplication started,use {}", System.currentTimeMillis() - timestamp);
    }
}