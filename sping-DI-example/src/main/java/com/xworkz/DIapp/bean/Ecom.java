package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component


public class Ecom {

    @Value("11")
    private int id;

    @Value("flipcart")
    private String appName;

    @Autowired
    private Product product;
}
