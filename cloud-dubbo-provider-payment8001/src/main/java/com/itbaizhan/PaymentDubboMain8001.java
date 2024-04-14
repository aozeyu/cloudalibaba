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
public class PaymentDubboMain8001 {
  public static void main(String[] args) {
    SpringApplication.run(PaymentDubboMain8001.class,args);
    log.info("PaymentDubboMain8001 启动成功");
  }
}
