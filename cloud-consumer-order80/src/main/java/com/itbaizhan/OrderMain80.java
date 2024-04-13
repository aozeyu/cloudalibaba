package com.itbaizhan;


import lombok.extern.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.*;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class OrderMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderMain80.class,args);
    log.info("orderMan80启动成功");
  }
}
