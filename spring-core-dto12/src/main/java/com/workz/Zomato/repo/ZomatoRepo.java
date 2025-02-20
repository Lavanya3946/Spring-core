package com.workz.Zomato.repo;

import com.workz.Zomato.entity.ZomatoEntity;

public interface ZomatoRepo {
    boolean save(ZomatoEntity zomatoEntity);

    ZomatoEntity getById(Integer id);

    void getByName(String food_name);

    ZomatoEntity updateCostByName(String food_name, Integer cost);

    void removeById(Integer id);
}
