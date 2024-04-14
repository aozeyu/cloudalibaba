package com.itbaizhan.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author yaozeyu
 */
@RestController
@RequestMapping("payment")
public class PaymentControler {

  @GetMapping
  public String index() {
    return "payment success";
  }
}
