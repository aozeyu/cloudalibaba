package com.itbaizhan.service;

import org.springframework.cloud.openfeign.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


/**
 * @author yaozeyu
 */ //远程调用
@Service
@FeignClient(value = "payment-provider")
public interface IPaymentFeginsService {
    @GetMapping("/payment/index")
   String index();
}
