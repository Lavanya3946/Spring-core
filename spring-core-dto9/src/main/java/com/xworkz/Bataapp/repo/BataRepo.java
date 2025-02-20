package com.xworkz.Bataapp.repo;

import com.xworkz.Bataapp.entity.BataEntity;

public interface BataRepo {
    boolean save(BataEntity bataEntity);

    BataEntity getById(Integer id);

    void getByType(String shoe_type);

    BataEntity updatePriceByType(double price, String shoe_type);

    void removeById(Integer id);
}
