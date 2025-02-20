package com.xworkz.cosmeticsapp.repo;

import com.xworkz.cosmeticsapp.entity.CosmeticsEntity;

public interface CosmeticsRepo {
    boolean save(CosmeticsEntity cosmeticsEntity);

    CosmeticsEntity getById(Integer id);

    void getByBrand(String brand);

    void updateCostByType(Integer cost, String type);

    void removeById(Integer id);
}
