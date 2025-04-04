package com.swms.order.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OnlineOrderDto {
    private int onlineWarehouseId;
    private int shoesId;
    private int quantity;
}
