package com.xworkz.cosmeticsapp.service;

import com.xworkz.cosmeticsapp.dto.CosmeticsDto;

public interface CosmeticsService {
    boolean validateAndSave(CosmeticsDto cosmeticsDto);

    boolean getById(Integer id);

    void getByBrand(String brand);

    boolean updateCostByType(Integer cost, String type);

    void removeById(Integer id);
}
