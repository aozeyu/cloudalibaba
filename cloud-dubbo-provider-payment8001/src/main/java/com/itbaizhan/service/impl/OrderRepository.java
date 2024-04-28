package com.itbaizhan.service.impl;

import com.itbaizhan.model.*;
import org.springframework.data.elasticsearch.repository.*;

public interface OrderRepository extends ElasticsearchRepository<OrderModel,Long> {

}
