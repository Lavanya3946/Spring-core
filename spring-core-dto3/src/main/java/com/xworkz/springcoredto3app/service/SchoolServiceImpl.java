package com.xworkz.springcoredto3app.service;

import com.xworkz.springcoredto3app.dto.SchoolDto;
import com.xworkz.springcoredto3app.entity.SchoolEntity;
import com.xworkz.springcoredto3app.repo.SchoolRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


@Component
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public boolean validateAndSave(SchoolDto schoolDto) {
        boolean saveSchool = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<SchoolDto>> violations = validator.validate(schoolDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        SchoolEntity schoolEntity = new SchoolEntity();
        BeanUtils.copyProperties(schoolDto, schoolEntity);
        saveSchool = schoolRepo.save(schoolEntity);
        return saveSchool;
    }

    @Override
    public boolean getById(Integer id) {
        SchoolEntity schoolEntity = schoolRepo.getById(id);
        System.out.println(schoolEntity);
        return false;
    }

    @Override
    public boolean getByName(String school_name) {
        schoolRepo.getByName(school_name);
        return false;
    }

    @Override
    public void updateLocationByName(String school_name, String location) {
        SchoolEntity schoolEntity = schoolRepo.updateLocationByName(location, school_name);
        if (schoolEntity != null) {
            System.out.println("updated succesfully.." + schoolEntity);
        } else {
            System.out.println("not updated ");
        }
    }

    @Override
    public void removeById(Integer id) {
        schoolRepo.removeById(id);
    }
}
