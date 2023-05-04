package com.academy.hospital.service.impl;

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

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }
}
