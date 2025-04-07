package com.swms.order.model.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OnlineOrderDetailDto {
    private int onlineOrderDetailId;
    private int orderId;
    private int shoesId;
    private int quantity;
}
