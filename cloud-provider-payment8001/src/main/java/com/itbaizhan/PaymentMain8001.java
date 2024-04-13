package com.itbaizhan;


import lombok.extern.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.*;

/**
 * @author yaozeyu
 */
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class PaymentMain8001 {
  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8001.class,args);
    log.info("PaymentMain8001启动成功");
  }
}
