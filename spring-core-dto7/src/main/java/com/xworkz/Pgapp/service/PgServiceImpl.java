package com.xworkz.Pgapp.service;

import com.xworkz.Pgapp.dto.PgDto;
import com.xworkz.Pgapp.entity.PgEntity;
import com.xworkz.Pgapp.repo.PgRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class PgServiceImpl implements PgService {

    @Autowired
    private PgRepo pgRepo;

    @Override
    public boolean validateAndSave(PgDto pgDto) {
        boolean savePg = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<PgDto>> violations = validator.validate(pgDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        PgEntity pgEntity = new PgEntity();
        BeanUtils.copyProperties(pgDto, pgEntity);
        savePg = pgRepo.save(pgEntity);
        return savePg;
    }

    @Override
    public boolean getById(Integer id) {
        PgEntity pg = pgRepo.getById(id);
        System.out.println(pg);
        return false;
    }

    @Override
    public boolean getByName(String pg_name) {
        pgRepo.getByName(pg_name);

        return false;
    }

    @Override
    public void updateCostByName(String pg_name, Integer cost) {
        PgEntity pg = pgRepo.updateCostByName(pg_name, cost);
        if (pg != null) {
            System.out.println("updated succesfully.." + pg);
        } else {
            System.out.println("can not update the population ");
        }
    }

    @Override
    public void removeById(Integer id) {
        pgRepo.removeBYId(id);

    }
}
