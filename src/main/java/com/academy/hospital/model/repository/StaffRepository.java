package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository <Staff, Integer> {
}
