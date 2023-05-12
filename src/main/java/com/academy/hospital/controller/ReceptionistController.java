package com.academy.hospital.controller;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.model.entity.Patient;
import com.academy.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReceptionistController {

    private final PatientService patientService;

    @GetMapping("/receptionist")
    public String showMainPageReceptionist() {
        return "receptionistPages/receptionistMainPage";
    }

    @GetMapping("/searchPatient")
    public String searchPatient(@RequestParam String name, @RequestParam String surname, @RequestParam String patronymic, Model model) {
        List<PatientDto> patients = patientService.findByParameters(surname, name, patronymic);
        model.addAttribute("patients", patients);
        return "receptionistPages/findPatient";
    }


    @GetMapping("/showCreatePatient")
    public String showCreatePatient(Model model) {
        PatientDto patientDto = new PatientDto();
        model.addAttribute("createPatient", patientDto);
        return "receptionistPages/createPatient";
    }


    @PostMapping("/createPatient")
    public String createPatient(@ModelAttribute("createPatient") PatientDto createPatient, Model model) {
       PatientDto patient= patientService.save(createPatient);
       model.addAttribute("patient", patient);

        /*employeeService.save(createEmployee);
        List<EmployeeDto> employees = employeeService.findAll();
        model.addAttribute("employees", employees);*/
        return "receptionistPages/patientDetails";
    }


    @GetMapping("/patient")
    public String findPatient(@RequestParam(value = "id") Integer id, Model model) {
        PatientDto patientDto = patientService.find(id);
        model.addAttribute("patient", patientDto);
        return "receptionistPages/patientDetails";
    }


    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute("patient") PatientDto updatePatient, Model model) {

        /*employeeService.save(createEmployee);
        List<EmployeeDto> employees = employeeService.findAll();
        model.addAttribute("employees", employees);*/
        return "receptionistPages/patientDetails";
    }

}
