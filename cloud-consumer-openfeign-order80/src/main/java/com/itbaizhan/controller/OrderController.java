package com.itbaizhan.controller;


//订单服务调用 pay服务

import com.itbaizhan.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author yaozeyu
 */
@RestController
@RequestMapping("order")
public class OrderController {
  @Autowired
  private IPaymentFeginsService iPaymentFeginsService;

 @GetMapping("index")
  public String index() {
   return iPaymentFeginsService.index();
 }
}
