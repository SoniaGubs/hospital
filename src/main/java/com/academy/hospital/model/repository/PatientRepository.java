package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findBySurnameAndNameAndPatronymicOrderByNameAsc(String surname, String name, String patronymic);
    List<Patient> findBySurnameAndNameOrderByNameAsc(String surname, String name);
    List<Patient> findBySurnameOrderByNameAsc(String surname);

}
