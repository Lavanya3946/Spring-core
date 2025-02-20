package com.xworkz.jewelleryapp.service;

import com.xworkz.jewelleryapp.dto.JewelleryDto;
import com.xworkz.jewelleryapp.entity.JewelleryEntity;

public interface JewelleryService {
    boolean validateAndSave(JewelleryDto jewelleryDto);

    boolean getById(Integer id);

    void getByName(String name);

    JewelleryEntity updateTypeByName(String type, String name);

    void removeById(Integer id);
}
