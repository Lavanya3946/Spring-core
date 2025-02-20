package com.xworkz.Pgapp.service;

import com.xworkz.Pgapp.dto.PgDto;

public interface PgService {
    boolean validateAndSave(PgDto pgDto);

    boolean getById(Integer id);

    boolean getByName(String pg_name);

    void updateCostByName(String pg_name, Integer cost);

    void removeById(Integer id);
}
