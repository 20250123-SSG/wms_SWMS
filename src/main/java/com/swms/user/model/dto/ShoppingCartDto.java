package com.swms.user.model.dto;

import com.swms.shoes.model.dto.ShoesDto;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShoppingCartDto {
    private int cartId;
    private int userId;
    private int shoesId;
    private Timestamp cartDate;

    private ShoesDto shoesName;
    private ShoesDto shoesPrice;
    private ShoesDto size;
}
