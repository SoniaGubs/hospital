package com.academy.hospital.controller;

import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.service.DiagnosisService;
import com.academy.hospital.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DoctorController {

    private final CardService cardService;
    private final DiagnosisService diagnosisService;

    @GetMapping("/card")
    public String findCard(@RequestParam(value = "id") Integer id, Model model) {
        Card card = cardService.findReception(id);
        model.addAttribute("card", card);
        return "cardDetailsForDoctor";
    }

/*
    @GetMapping("/showSetDiagnosis")
    public String showSetDiagnosis() {
        return "createDiagnosis";
    }


    @GetMapping("/createDiagnosis")
    public String setDiagnosis(@RequestParam String name, Model model) {
        Diagnosis diagnosis = diagnosisService.save(name);
        return "";

      receptionService.setDiagnosis(diagnosis, id);
        diagnosisService.findDiagnosis(diagnosis.getId());

    }*/


}
