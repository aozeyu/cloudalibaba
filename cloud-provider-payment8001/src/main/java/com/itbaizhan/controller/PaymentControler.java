package com.itbaizhan.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.*;

/**
 * @author yaozeyu
 */
@RestController
@RequestMapping("payment")
public class PaymentControler {

  @GetMapping("/index")
  public String index() throws InterruptedException {
    TimeUnit.SECONDS.sleep(5000);
    return "payment success";
  }
}
