package com.itbaizhan;


import lombok.extern.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.*;

/**
 * @author yaozeyu
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class OrderOpenFeignMain80 {
  public static void main(String[] args) {
    SpringApplication.run(OrderOpenFeignMain80.class,args);

    log.info("OrderOpenFeignMain80 启动成功过");
  }
}
