package com.workz.Zomato.service;

import com.workz.Zomato.dto.ZomatoDto;

public interface ZomatoService {
    boolean validateAndSave(ZomatoDto zomatoDto);

    boolean getById(Integer id);

    boolean getByName(String food_name);

    void updateCostByName(String food_name, Integer cost);

    void removeById(Integer id);
}
