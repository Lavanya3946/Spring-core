package com.xworkz.springcoredto2app.service;

import com.xworkz.springcoredto2app.dto.DistrictDto;


public interface DistrictService {
    boolean validateAndSave(DistrictDto districtDto);

    boolean getById(Integer id);

    boolean getByName(String district_name);

    void updateTalukByName(String district_name, Integer no_Of_Taluks);

    void removeById(Integer id);
}
