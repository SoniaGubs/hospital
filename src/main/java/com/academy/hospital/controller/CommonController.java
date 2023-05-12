package com.academy.hospital.controller;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.PatientService;
import com.academy.hospital.service.StaffService;
import com.academy.hospital.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommonController {

    private final CardService cardService;
    private final PatientService patientService;
    private final StaffService staffService;
    private final TreatmentService treatmentService;


 /*   @GetMapping("/allReceptions")
    public String getAll(Model model) {
        List <Card> cards = cardService.findAll();
        model.addAttribute("allReceptions", cards);
        return "allReceptions";
    }
*/

    @GetMapping("/sicks")
    public String getAllSick(Model model) {
        List <CardDto> cards = cardService.findSick();
        model.addAttribute("sicks", cards);
        return "sicks";

    }



}
