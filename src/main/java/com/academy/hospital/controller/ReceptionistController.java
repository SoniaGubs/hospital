package com.academy.hospital.controller;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.PatientDto;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReceptionistController {
    private final PatientService patientService;
    private final CardService cardService;

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

    @RequestMapping("/showCreateUpdatePatient")
    public String showCreateUpdatePatient(@ModelAttribute("patient") PatientDto updatePatient, Model model) {
        if (updatePatient != null) {
            model.addAttribute("patient", updatePatient);
        } else {
            PatientDto patientDto = new PatientDto();
            model.addAttribute("patient", patientDto);
        }
        return "receptionistPages/createUpdatePatient";
    }

    @PostMapping("/createUpdatePatient")
    public String createUpdatePatient(@ModelAttribute("patient") PatientDto createPatient, Model model) {
        PatientDto patient = patientService.save(createPatient);
        model.addAttribute("patient", patient);
        return "receptionistPages/patientDetails";
    }

    @GetMapping("/patient")
    public String findPatient(@RequestParam(value = "id") Integer id, Model model) {
        PatientDto patientDto = patientService.find(id);
        model.addAttribute("patient", patientDto);
        return "receptionistPages/patientDetails";
    }


    @GetMapping("/createCard")
    public String createCard(@RequestParam(value = "id") Integer id, Model model) {
        PatientDto patientDto = patientService.find(id);
        CardDto card = new CardDto();
        card.setDateOfAdmission(LocalDate.now());
        card.setPatient(patientDto);
        cardService.save(card);

        return "receptionistPages/receptionistMainPage";
    }





}