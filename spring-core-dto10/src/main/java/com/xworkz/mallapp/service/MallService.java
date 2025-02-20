package com.xworkz.mallapp.service;

import com.xworkz.mallapp.dto.MallDto;
import com.xworkz.mallapp.entity.MallEntity;

public interface MallService {
    boolean validateAndsave(MallDto mallDto);

    boolean getById(Integer id);

    MallEntity getByName(String mall_name);

    void updateLocationByName(String location, String mall_name);

    void removeById(Integer id);
}
