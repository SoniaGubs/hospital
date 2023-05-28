package com.academy.hospital.service;

import com.academy.hospital.dto.StaffDto;
import com.academy.hospital.model.entity.Role;
import com.academy.hospital.model.entity.Staff;

import java.util.List;

public interface StaffService {

    List<StaffDto> findByRole(Role role);

    StaffDto findById(Integer id);

    StaffDto findByUserId (Integer userId);
}
