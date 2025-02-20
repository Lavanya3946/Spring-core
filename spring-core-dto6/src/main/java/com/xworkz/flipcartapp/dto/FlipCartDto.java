package com.xworkz.flipcartapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString


public class FlipCartDto {
    private Integer id;
    private String productName;
    private Integer cost;
}
