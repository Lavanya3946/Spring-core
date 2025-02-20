package com.xworkz.springcoredto2app.service;

import com.xworkz.springcoredto2app.dto.DistrictDto;
import com.xworkz.springcoredto2app.entity.DistrictEntity;
import com.xworkz.springcoredto2app.repo.DistrictRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;

@Component
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepo districtRepo;

    @Override
    public boolean validateAndSave(DistrictDto districtDto) {
        boolean saveDistrict = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DistrictDto>> violations = validator.validate(districtDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        DistrictEntity districtEntity = new DistrictEntity();
        BeanUtils.copyProperties(districtDto, districtEntity);
        saveDistrict = districtRepo.save(districtEntity);
        return saveDistrict;
    }

    @Override
    public boolean getById(Integer id) {
        DistrictEntity districtEntity = districtRepo.getById(id);
        System.out.println(districtEntity);
        return false;
    }

    @Override
    public boolean getByName(String district_name) {
        districtRepo.getByName(district_name);
        return false;
    }

    @Override
    public void updateTalukByName(String district_name, Integer no_Of_Taluks) {
        DistrictEntity districtEntity = districtRepo.updateTaluksByName(district_name, no_Of_Taluks);
        if (districtEntity != null) {
            System.out.println("updated succesfully.." + districtEntity);
        } else {
            System.out.println("not updated");
        }

    }

    @Override
    public void removeById(Integer id) {
        districtRepo.removeById(id);
    }
}
