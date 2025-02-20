package com.xworkz.jewelleryapp.service;

import com.xworkz.jewelleryapp.dto.JewelleryDto;
import com.xworkz.jewelleryapp.entity.JewelleryEntity;
import com.xworkz.jewelleryapp.repo.JewelleryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class JewelleryServiceImpl implements JewelleryService {
    @Autowired
    private JewelleryRepo jewelleryRepo;

    @Override
    public boolean validateAndSave(JewelleryDto jewelleryDto) {
        boolean Savejewellery = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<JewelleryDto>> violations = validator.validate(jewelleryDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        JewelleryEntity jewelleryEntity = new JewelleryEntity();
        BeanUtils.copyProperties(jewelleryDto, jewelleryEntity);
        Savejewellery = jewelleryRepo.save(jewelleryEntity);
        return Savejewellery;

    }

    @Override
    public boolean getById(Integer id) {
        JewelleryEntity jewelleryEntity = jewelleryRepo.getById(id);
        System.out.println(jewelleryEntity);
        return false;
    }

    @Override
    public void getByName(String name) {
        jewelleryRepo.getByName(name);
    }

    @Override
    public JewelleryEntity updateTypeByName(String type, String name) {
        jewelleryRepo.updateTypeByName(type, name);
        return null;
    }

    @Override
    public void removeById(Integer id) {
        jewelleryRepo.removeById(id);

    }
}
