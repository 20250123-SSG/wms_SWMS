package com.swms.warehouse.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PurchaseOrderDto {
    private int purchaseOrderId;
    private int storeId;
    private int shoesId;
    private String storeName;
    private String brandName;
    private String shoesType;
    private String shoesName;
    private int size;
    private int quantity;
    private LocalDateTime requestDate;
    private String status;
    private LocalDateTime completionDate;
}
