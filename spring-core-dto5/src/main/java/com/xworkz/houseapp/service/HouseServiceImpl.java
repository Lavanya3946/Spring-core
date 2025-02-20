package com.xworkz.houseapp.service;

import com.xworkz.houseapp.dto.HouseDto;
import com.xworkz.houseapp.entity.HouseEntity;
import com.xworkz.houseapp.repo.HouseRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepo houseRepo;

    @Override
    public boolean validateAndSave(HouseDto houseDto) {
        boolean saveHouse = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<HouseDto>> violations = validator.validate(houseDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        HouseEntity houseEntity = new HouseEntity();
        BeanUtils.copyProperties(houseDto, houseEntity);
        saveHouse = houseRepo.save(houseEntity);
        return saveHouse;
    }

    @Override
    public Boolean getById(Integer id) {
        HouseEntity stateEntity = houseRepo.getById(id);
        System.out.println(stateEntity);
        return null;
    }

    @Override
    public Boolean getByName(String house_name) {
        houseRepo.getByName(house_name);
        return false;
    }

    @Override
    public void updateHouseNoByName(String house_name, Integer houseNo) {
        HouseEntity houseEntity = houseRepo.updateHouseNoByName(house_name, houseNo);
        if (houseEntity != null) {
            System.out.println("updated succesfully.." + houseEntity);
        } else {
            System.out.println("can not update the population ");
        }
    }

    @Override
    public void removeById(Integer id) {
        houseRepo.removeBYId(id);
    }
}
