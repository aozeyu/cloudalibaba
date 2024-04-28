import com.alibaba.fastjson2.*;
import com.itbaizhan.model.*;
import com.itbaizhan.service.impl.*;
import org.elasticsearch.index.query.*;
import org.hibernate.cfg.annotations.*;
import org.junit.*;
import org.springframework.data.elasticsearch.core.query.*;

import javax.annotation.*;

import java.util.*;

public class test1 {

  @Resource
  private OrderRepository orderRepository;
   @Test
  public void test2() {
     OrderModel orderModel = new OrderModel();
     orderModel.setOrderId(1L);
     orderModel.setAmount(25.5);
     orderModel.setBuyerUid(13201L);
     orderModel.setShippingAddress("上海");
    orderModel = orderRepository.save(orderModel);
     System.out.println(orderModel);
   }



   @Test
  public void test3() {
//     BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//     NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder()
//         .withQuery(boolQueryBuilder);
//     List<OrderModel> orderDocumentList = orderRepository.search(searchQueryBuilder.build()).getContent();
//     System.out.println(JSON.toJSONString(orderDocumentList));
   }
}
