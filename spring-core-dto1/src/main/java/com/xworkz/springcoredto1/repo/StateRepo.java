package com.xworkz.springcoredto1.repo;

import com.xworkz.springcoredto1.entity.StateEntity;

public interface StateRepo {

      boolean save(StateEntity stateEntity);

      StateEntity getById(Integer id);

      Void getByName(String state_name);

      StateEntity updateStateNameByNOfPopulation(String state_name,Integer no_OfPeople);

      void removeBYId(Integer id);
}
