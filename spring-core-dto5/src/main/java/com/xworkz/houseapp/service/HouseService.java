package com.xworkz.houseapp.service;

import com.xworkz.houseapp.dto.HouseDto;


public interface HouseService {
    boolean validateAndSave(HouseDto houseDto);

    Boolean getById(Integer id);

    Boolean getByName(String house_name);

    void updateHouseNoByName(String house_name, Integer houseNo);

    void removeById(Integer id);
}
