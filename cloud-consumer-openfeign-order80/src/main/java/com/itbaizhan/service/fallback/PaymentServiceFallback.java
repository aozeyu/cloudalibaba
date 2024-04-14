package com.itbaizhan.service.fallback;

import com.itbaizhan.service.*;
import org.springframework.stereotype.*;

/**
 * @author yaozeyu
 */
@Component
public class PaymentServiceFallback implements IPaymentFeginsService {
  //降级方法
  @Override
  public String index() {
    return "系统服务忙!";
  }
}
