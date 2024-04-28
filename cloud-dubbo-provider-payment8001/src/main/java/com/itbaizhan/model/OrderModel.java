package com.itbaizhan.model;


import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.*;

@Document(indexName = "order")
@Data
public class OrderModel {

  @Id
  private Long orderId;
  private Double amount;
  private Long buyerUid;
  private String shippingAddress;
}
