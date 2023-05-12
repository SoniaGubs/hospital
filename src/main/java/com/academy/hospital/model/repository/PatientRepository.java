package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findBySurnameAndNameAndPatronymicOrderBySurnameAsc(String surname, String name, String patronymic);
    List<Patient> findBySurnameAndNameOrderBySurnameAsc(String surname, String name);
    List<Patient> findBySurnameOrderBySurnameAsc(String surname);

}
