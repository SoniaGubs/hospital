package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Role;
import com.academy.hospital.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository <Staff, Integer> {

    List<Staff> findByUser_Roles(Role role);

    Staff findByUser_Id(Integer userId);


}
