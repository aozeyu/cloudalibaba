package com.itbaizhan.service.impl;

import com.itbaizhan.service.*;
import org.apache.dubbo.config.annotation.*;


@DubboService(timeout = 5000,methods = {@Method(name = "index")})
public class PaymentServiceImpl implements IPaymentService {
  @Override
  public String index() {
    return "";
  }
}
