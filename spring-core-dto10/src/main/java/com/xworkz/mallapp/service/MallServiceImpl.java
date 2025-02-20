package com.xworkz.mallapp.service;

import com.xworkz.mallapp.dto.MallDto;
import com.xworkz.mallapp.entity.MallEntity;
import com.xworkz.mallapp.repo.MallRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class MallServiceImpl implements MallService{
    @Autowired
    private MallRepo mallRepo;

    @Override
    public boolean validateAndsave(MallDto mallDto) {
        boolean saveMall=false;
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<MallDto>> violations=validator.validate(mallDto);
        if(!violations.isEmpty()){
            violations.stream().forEach(error-> System.out.println(error.getMessage()));
        }
        MallEntity mallEntity=new MallEntity();
        BeanUtils.copyProperties(mallDto,mallEntity);
        saveMall=mallRepo.save(mallEntity);
        return saveMall;
    }

    @Override
    public boolean getById(Integer id) {
       MallEntity mallEntity= mallRepo.getById(id);
        System.out.println(mallEntity);
        return false;
    }

    @Override
    public MallEntity getByName(String mall_name) {
        mallRepo.getByName(mall_name);
        return null;
    }

    @Override
    public void updateLocationByName(String location, String mall_name) {
        mallRepo.updateLocationByName(location,mall_name);
    }

    @Override
    public void removeById(Integer id) {
        mallRepo.removeById(id);
    }
}
