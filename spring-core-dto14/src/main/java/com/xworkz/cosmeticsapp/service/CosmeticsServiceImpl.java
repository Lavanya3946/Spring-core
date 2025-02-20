package com.xworkz.cosmeticsapp.service;

import com.xworkz.cosmeticsapp.dto.CosmeticsDto;
import com.xworkz.cosmeticsapp.entity.CosmeticsEntity;
import com.xworkz.cosmeticsapp.repo.CosmeticsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class CosmeticsServiceImpl implements CosmeticsService {
    @Autowired
    private CosmeticsRepo cosmeticsRepo;

    @Override
    public boolean validateAndSave(CosmeticsDto cosmeticsDto) {
        boolean countySave = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CosmeticsDto>> violations = validator.validate(cosmeticsDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        CosmeticsEntity cosmeticsEntity = new CosmeticsEntity();
        BeanUtils.copyProperties(cosmeticsDto, cosmeticsEntity);
        countySave = cosmeticsRepo.save(cosmeticsEntity);
        return countySave;

    }

    @Override
    public boolean getById(Integer id) {
        CosmeticsEntity cosmeticsEntity = cosmeticsRepo.getById(id);
        System.out.println(cosmeticsEntity);
        return false;
    }

    @Override
    public void getByBrand(String brand) {
        cosmeticsRepo.getByBrand(brand);
    }

    @Override
    public boolean updateCostByType(Integer cost, String type) {
        cosmeticsRepo.updateCostByType(cost, type);
        return false;
    }

    @Override
    public void removeById(Integer id) {
        cosmeticsRepo.removeById(id);
    }
}
