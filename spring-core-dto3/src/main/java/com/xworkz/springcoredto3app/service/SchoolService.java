package com.xworkz.springcoredto3app.service;

import com.xworkz.springcoredto3app.dto.SchoolDto;

public interface SchoolService {
    boolean validateAndSave(SchoolDto schoolDto);

    boolean getById(Integer id);

    boolean getByName(String school_name);

    void updateLocationByName(String school_name, String location);

    void removeById(Integer id);


}
