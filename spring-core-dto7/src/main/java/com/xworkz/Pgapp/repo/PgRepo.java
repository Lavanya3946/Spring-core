package com.xworkz.Pgapp.repo;

import com.xworkz.Pgapp.entity.PgEntity;

public interface PgRepo {
    boolean save(PgEntity pgEntity);

    PgEntity getById(Integer id);

    Void getByName(String pg_name);

    PgEntity updateCostByName(String pg_name, Integer cost);

    void removeBYId(Integer id);
}
