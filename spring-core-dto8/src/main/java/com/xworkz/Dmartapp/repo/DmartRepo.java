package com.xworkz.Dmartapp.repo;

import com.xworkz.Dmartapp.entity.DmartEntity;

public interface DmartRepo {
    boolean save(DmartEntity dmartEntity);

    DmartEntity getById(Integer id);

    void getByLocation(String location);

    DmartEntity updateEmployeeByLocation(Integer no_Of_Employees, String location);

    void removeById(Integer id);
}
