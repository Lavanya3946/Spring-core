package com.xworkz.flipcartapp.service;

import com.xworkz.flipcartapp.dto.FlipCartDto;

public interface FlipCartService {
    boolean validateAndSave(FlipCartDto flipCartDto);
    Boolean getById(Integer id);

    Boolean getByName(String state_name);

    Void updateCostByName(String product_Name, Integer cost);

    void removeById(Integer id);
}
