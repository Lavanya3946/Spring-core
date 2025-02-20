package com.xworkz.Pgapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class PgDto {
    private Integer id;
    private String pgName;
    private Integer cost;
}
