package com.xworkz.mobileapp.service;

import com.xworkz.mobileapp.dto.MobileDto;
import com.xworkz.mobileapp.entity.MobileEntity;
import com.xworkz.mobileapp.repo.MobileRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class MobileServiceImpl implements MobileService {

    @Autowired
    private MobileRepo mobileRepo;

    @Override
    public boolean validateAndSave(MobileDto mobileDto) {

        boolean saveMobile = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<MobileDto>> violations = validator.validate(mobileDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> error.getMessage());
        }
        MobileEntity mobileEntity = new MobileEntity();
        BeanUtils.copyProperties(mobileDto, mobileEntity);
        saveMobile = mobileRepo.save(mobileEntity);
        return saveMobile;
    }

    @Override
    public boolean getById(Integer id) {
        MobileEntity mobileEntity = mobileRepo.getById(id);
        System.out.println(mobileEntity);
        return false;
    }

    @Override
    public void getByName(String mobile_brand) {
        mobileRepo.getByName(mobile_brand);

    }
}
