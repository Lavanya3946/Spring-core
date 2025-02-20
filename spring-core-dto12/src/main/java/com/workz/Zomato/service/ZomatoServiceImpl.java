package com.workz.Zomato.service;

import com.workz.Zomato.dto.ZomatoDto;
import com.workz.Zomato.entity.ZomatoEntity;
import com.workz.Zomato.repo.ZomatoRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class ZomatoServiceImpl implements ZomatoService {

    @Autowired
    private ZomatoRepo zomatoRepo;

    @Override
    public boolean validateAndSave(ZomatoDto zomatoDto) {
        boolean saveZomato = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ZomatoDto>> violations = validator.validate(zomatoDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        ZomatoEntity zomatoEntity = new ZomatoEntity();
        BeanUtils.copyProperties(zomatoDto, zomatoEntity);
        saveZomato = zomatoRepo.save(zomatoEntity);
        return saveZomato;
    }

    @Override
    public boolean getById(Integer id) {
        ZomatoEntity zomatoEntity = zomatoRepo.getById(id);
        System.out.println(zomatoEntity);
        return false;
    }

    @Override
    public boolean getByName(String food_name) {
        zomatoRepo.getByName(food_name);
        return false;
    }

    @Override
    public void updateCostByName(String food_name, Integer cost) {
        ZomatoEntity zomatoEntity = zomatoRepo.updateCostByName(food_name, cost);
        System.out.println(zomatoEntity);
    }

    @Override
    public void removeById(Integer id) {
        zomatoRepo.removeById(id);
    }
}
