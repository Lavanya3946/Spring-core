package com.xworkz.Bataapp.service;

import com.xworkz.Bataapp.dto.BataDto;
import com.xworkz.Bataapp.entity.BataEntity;
import com.xworkz.Bataapp.repo.BataRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class BataServiceImpl implements BataService {
    @Autowired
    private BataRepo bataRepo;

    @Override
    public boolean validateAndSave(BataDto bataDto) {

        boolean saveBata = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<BataDto>> violations = validator.validate(bataDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        BataEntity bataEntity = new BataEntity();
        BeanUtils.copyProperties(bataDto, bataEntity);
        saveBata = bataRepo.save(bataEntity);
        return saveBata;
    }

    @Override
    public boolean getById(Integer id) {
        BataEntity bataEntity = bataRepo.getById(id);
        System.out.println(bataEntity);
        return false;
    }

    @Override
    public BataEntity getByType(String shoe_type) {
        bataRepo.getByType(shoe_type);
        return null;
    }

    @Override
    public void updatePriceByType(Double price, String shoe_type) {
        bataRepo.updatePriceByType(price, shoe_type);
    }

    @Override
    public void removeById(Integer id) {
        bataRepo.removeById(id);
    }
}
