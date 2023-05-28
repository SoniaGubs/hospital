package com.academy.hospital.service.impl;

import com.academy.hospital.dto.StaffDto;
import com.academy.hospital.mapper.StaffMapper;
import com.academy.hospital.model.entity.Staff;
import com.academy.hospital.model.repository.StaffRepository;
import com.academy.hospital.service.StaffService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StaffServiceTest {

    @InjectMocks
    private StaffService staffService;

    @Mock
    private StaffMapper staffMapper;

    @Mock
    private StaffRepository staffRepository;


    @Test
    void testFindById() {
        Staff staff = new Staff();
        staff.setId(1);
        when(staffRepository.getReferenceById(1)).thenReturn(staff);

        StaffDto staffDto = new StaffDto();
        staffDto.setId(1);
        when(staffMapper.toDto(staff)).thenReturn(staffDto);

        StaffDto lucky = staffService.findById(1);
        verify(staffRepository).getReferenceById(1);
        verify(staffMapper).toDto(staff);
        assertEquals(1, lucky.getId());

    }


}
