package com.academy.hospital.controller;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReceptionistController {
    private final PatientService patientService;
    private final CardService cardService;

    @GetMapping("/receptionist/mainPage")
    public String showMainPageReceptionist() {
        return "receptionistPages/receptionistMainPage";
    }

    @GetMapping("/receptionist/searchPatient")
    public String searchPatient(@RequestParam String name, @RequestParam String surname, @RequestParam String patronymic, Model model) {
        List<PatientDto> patients = patientService.findByParametersAndOrderByName(surname, name, patronymic);
        model.addAttribute("patients", patients);
        return "receptionistPages/findPatient";
    }


    @GetMapping("/receptionist/showCreateUpdatePatient")
    public String showFormPatient(Model model) {
        PatientDto createPatient = new PatientDto();
        model.addAttribute("patient", createPatient);
        return "receptionistPages/createUpdatePatient";
    }

    @PostMapping("/receptionist/showCreateUpdatePatient")
    public String showFormPatient(@ModelAttribute("patient") PatientDto updatePatient, Model model) {
        model.addAttribute("patient", updatePatient);
        return "receptionistPages/createUpdatePatient";
    }


    @PostMapping("/receptionist/createUpdatePatient")
    public String createUpdatePatient(@ModelAttribute("patient") PatientDto createPatient, Model model) {
        PatientDto patientDto = patientService.save(createPatient);
        model.addAttribute("patient", patientDto);
        return "receptionistPages/patientDetails";
    }

    @GetMapping("/receptionist/patient")
    public String findPatient(@RequestParam(value = "id") Integer id, Model model) {
        PatientDto patientDto = patientService.find(id);
        model.addAttribute("patient", patientDto);
        return "receptionistPages/patientDetails";
    }


    @GetMapping("/receptionist/createCard")
    public String createCard(@RequestParam(value = "id") Integer id, Model model) {
        PatientDto patientDto = patientService.find(id);
        CardDto card = cardService.save(patientDto);
        model.addAttribute("card", card);
        return "receptionistPages/successCreateCard";
    }


}