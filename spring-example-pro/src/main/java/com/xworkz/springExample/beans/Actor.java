package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Component

public class Actor {
    private int id;
    private String actorName;
    private String language;

    @Autowired
    public Actor(@Value("1") int id, @Value("sudeep") String actorName, @Value("kannada") String language) {
        this.id = id;
        this.actorName = actorName;
        this.language = language;
    }
}
