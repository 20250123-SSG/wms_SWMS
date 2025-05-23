package com.swms.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CartDto {
    private Integer cartId;
    private int userId;
    private int shoesId;
    private String cartDate;
}
