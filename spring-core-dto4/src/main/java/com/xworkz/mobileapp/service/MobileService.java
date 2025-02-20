package com.xworkz.mobileapp.service;

import com.xworkz.mobileapp.dto.MobileDto;

public interface MobileService {
    boolean validateAndSave(MobileDto mobileDto);
    boolean getById(Integer id);
    void getByName(String mobile_brand);

}
