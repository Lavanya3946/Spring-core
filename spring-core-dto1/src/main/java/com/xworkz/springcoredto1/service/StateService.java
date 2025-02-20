package com.xworkz.springcoredto1.service;

import com.xworkz.springcoredto1.dto.StateDto;

import javax.persistence.criteria.CriteriaBuilder;

public interface StateService  {
    boolean validateAndSave(StateDto stateDto);

    Boolean getById(Integer id);

    Boolean getByName(String state_name);

    Void updateStateNameByNOfPopulation(String state_name, Integer no_OfPeople);

    void removeById(Integer id);
}
