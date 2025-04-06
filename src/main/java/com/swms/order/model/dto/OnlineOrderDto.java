package com.swms.order.model.dto;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dto.UserDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OnlineOrderDto {
    private int orderId;
    private int userId;
    private int totalPrice;
    private String size;
    // UserDto + ShoesDto
}
