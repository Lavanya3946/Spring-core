package com.xworkz.springcoredto2app.repo;

import com.xworkz.springcoredto2app.entity.DistrictEntity;

public interface DistrictRepo {
    boolean save(DistrictEntity districtEntity);

    DistrictEntity getById(Integer id);

    void getByName(String district_name);

    DistrictEntity updateTaluksByName(String district_name, Integer no_Of_Taluks);

    void removeById(Integer id);
}
