package com.xworkz.jewelleryapp.repo;

import com.xworkz.jewelleryapp.entity.JewelleryEntity;

public interface JewelleryRepo {
    boolean save(JewelleryEntity jewelleryEntity);

    JewelleryEntity getById(Integer id);

    void getByName(String name);

    void updateTypeByName(String type, String name);

    void removeById(Integer id);
}
