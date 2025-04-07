package com.swms.order.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OfflineOrderDto {
    private int offlineWarehouseId;
    private int shoesId;
    private int quantity;
}
