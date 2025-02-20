package com.xworkz.springcoredto3app.repo;

import com.xworkz.springcoredto3app.entity.SchoolEntity;

public interface SchoolRepo {
    boolean save(SchoolEntity schoolEntity);

    SchoolEntity getById(Integer id);

    void getByName(String school_name);

    SchoolEntity updateLocationByName(String location, String school_name);

    void removeById(Integer id);

}
