package com.xworkz.DIapp.address;

import com.sun.org.glassfish.gmbal.ManagedObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component

public class Product {
    @Value("11")
    private int id;

    @Value("bag")
    private String name;

}
