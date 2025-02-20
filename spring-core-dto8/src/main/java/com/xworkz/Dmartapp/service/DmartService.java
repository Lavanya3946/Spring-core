package com.xworkz.Dmartapp.service;

import com.xworkz.Dmartapp.dto.DmartDto;

public interface DmartService {
    boolean validateAndSave(DmartDto dmartDto);

    boolean getById(Integer id);

    boolean getByLocation(String location);

    void updateEmployeesByLocation(String location, Integer no_Of_Employees);

    void removeById(Integer id);
}
