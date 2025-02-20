package com.xworkz.flipcartapp.repo;

import com.xworkz.flipcartapp.entity.FlipCartEntity;

public interface FlipCartRepo {
    boolean save(FlipCartEntity flipCartEntity);

    FlipCartEntity getById(Integer id);

    Void getByName(String state_name);

    FlipCartEntity updateCostByName(String product_Name, Integer cost);

    void removeBYId(Integer id);

}
