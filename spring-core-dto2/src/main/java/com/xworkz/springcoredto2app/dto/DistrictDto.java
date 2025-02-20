package com.xworkz.springcoredto2app.dto;

import com.sun.istack.internal.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class DistrictDto {
    private Integer id;
    private String name;
    private Integer noOfTaluks;
}
