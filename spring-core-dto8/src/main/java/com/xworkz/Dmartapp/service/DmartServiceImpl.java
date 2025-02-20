package com.xworkz.Dmartapp.service;

import com.xworkz.Dmartapp.dto.DmartDto;
import com.xworkz.Dmartapp.entity.DmartEntity;
import com.xworkz.Dmartapp.repo.DmartRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


@Component
public class DmartServiceImpl implements DmartService {

    @Autowired
    private DmartRepo dmartRepo;


    @Override
    public boolean validateAndSave(DmartDto dmartDto) {
        boolean saveDmart = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DmartDto>> violations = validator.validate(dmartDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }

        DmartEntity dmartEntity = new DmartEntity();
        BeanUtils.copyProperties(dmartDto, dmartEntity);
        saveDmart = dmartRepo.save(dmartEntity);

        return saveDmart;
    }

    @Override
    public boolean getById(Integer id) {
        DmartEntity dmartEntity = dmartRepo.getById(id);
        System.out.println(dmartEntity);
        return false;
    }

    @Override
    public boolean getByLocation(String location) {
        dmartRepo.getByLocation(location);
        return false;
    }

    @Override
    public void updateEmployeesByLocation(String location, Integer no_Of_Employees) {
        DmartEntity dmartEntity = dmartRepo.updateEmployeeByLocation(no_Of_Employees, location);
        if (dmartEntity != null) {
            System.out.println("updated successfully.." + dmartEntity);
        } else {
            System.out.println("not updated");
        }

    }

    @Override
    public void removeById(Integer id) {
        dmartRepo.removeById(id);
    }
}
