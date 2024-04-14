package com.itbaizhan.service;

import org.springframework.cloud.openfeign.*;

//远程调用
@FeignClient(value = "payment-provider")
public interface IPaymentFeginsService {
}
