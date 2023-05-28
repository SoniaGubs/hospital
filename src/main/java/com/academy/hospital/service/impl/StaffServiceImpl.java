package com.academy.hospital.service.impl;

import com.academy.hospital.dto.StaffDto;
import com.academy.hospital.mapper.StaffMapper;
import com.academy.hospital.model.entity.Role;
import com.academy.hospital.model.entity.Staff;
import com.academy.hospital.model.repository.StaffRepository;
import com.academy.hospital.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;


    @Override
    public List<StaffDto> findByRole(Role role) {
        return staffMapper.modelsToDto(staffRepository.findByUser_Roles(role));
    }

    @Override
    public StaffDto findById(Integer id) {
        return staffMapper.toDto(staffRepository.getReferenceById(id));
    }

    @Override
    public StaffDto findByUserId(Integer userId) {
        return staffMapper.toDto(staffRepository.findByUser_Id(userId));
    }


}
