package com.xworkz.springcoredto1.service;

import com.xworkz.springcoredto1.dto.StateDto;
import com.xworkz.springcoredto1.entity.StateEntity;
import com.xworkz.springcoredto1.repo.StateRepo;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;
@ToString
@Component
public class StateServiceImpl implements StateService{
    @Autowired
    private StateRepo stateRepo;

    @Override
    public boolean validateAndSave(StateDto stateDto) {
        boolean saveState=false;
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator= validatorFactory.getValidator();
        Set<ConstraintViolation<StateDto>> violations=validator.validate(stateDto);
        if(!violations.isEmpty()){
            violations.stream().forEach(error-> System.out.println(error.getMessage()));
        }
        StateEntity stateEntity=new StateEntity();
        BeanUtils.copyProperties(stateDto,stateEntity);
        saveState=stateRepo.save(stateEntity);

        return saveState;
    }

    @Override
    public Boolean getById(Integer id) {
        StateEntity stateEntity=stateRepo.getById(id);
        System.out.println(stateEntity);
        return null;
    }

    @Override
    public Boolean getByName(String state_name) {
        stateRepo.getByName(state_name);
        return false;
    }

    @Override
    public Void updateStateNameByNOfPopulation(String state_name, Integer no_OfPeople) {
        StateEntity stateEntity = stateRepo.updateStateNameByNOfPopulation(state_name, no_OfPeople);
        if (stateEntity != null) {
            System.out.println("updated succesfully.." + stateEntity);
        } else {
            System.out.println("can not update the population ");
        }
        return null;
    }

    @Override
    public void removeById(Integer id) {
        stateRepo.removeBYId(id);

    }
}
