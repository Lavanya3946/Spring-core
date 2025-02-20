package com.xworkz.flipcartapp.service;

import com.xworkz.flipcartapp.dto.FlipCartDto;
import com.xworkz.flipcartapp.entity.FlipCartEntity;
import com.xworkz.flipcartapp.repo.FlipCartRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class FlipCartServiceImpl implements FlipCartService {
    @Autowired
    private FlipCartRepo flipCartRepo;

    @Override
    public boolean validateAndSave(FlipCartDto flipCartDto) {
        boolean saveFlipCart = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<FlipCartDto>> violations = validator.validate(flipCartDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        FlipCartEntity flipCartEntity = new FlipCartEntity();
        BeanUtils.copyProperties(flipCartDto, flipCartEntity);
        saveFlipCart = flipCartRepo.save(flipCartEntity);
        return saveFlipCart;
    }

    @Override
    public Boolean getById(Integer id) {
        FlipCartEntity flipCartEntity = flipCartRepo.getById(id);
        System.out.println(flipCartEntity);
        return null;
    }

    @Override
    public Boolean getByName(String state_name) {
        flipCartRepo.getByName(state_name);
        return null;
    }

    @Override
    public Void updateCostByName(String product_Name, Integer cost) {
        FlipCartEntity flipCartEntity = flipCartRepo.updateCostByName(product_Name, cost);
        if (flipCartEntity != null) {
            System.out.println("updated succesfully.." + flipCartEntity);
        } else {
            System.out.println("can not update the population ");
        }
        return null;
    }

    @Override
    public void removeById(Integer id) {
        flipCartRepo.removeBYId(id);

    }
}
