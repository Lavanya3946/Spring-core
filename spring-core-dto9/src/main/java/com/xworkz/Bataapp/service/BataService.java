package com.xworkz.Bataapp.service;

import com.xworkz.Bataapp.dto.BataDto;
import com.xworkz.Bataapp.entity.BataEntity;

public interface BataService {
    boolean validateAndSave(BataDto bataDto);

    boolean getById(Integer id);

    BataEntity getByType(String shoe_type);

    void updatePriceByType(Double price, String shoe_type);

    void removeById(Integer id);

}
