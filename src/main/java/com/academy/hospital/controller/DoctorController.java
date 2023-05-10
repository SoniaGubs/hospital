package com.academy.hospital.controller;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.model.entity.Card;
import com.academy.hospital.model.entity.Diagnosis;
import com.academy.hospital.service.DiagnosisService;
import com.academy.hospital.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DoctorController {

    private final CardService cardService;
    private final DiagnosisService diagnosisService;

    @GetMapping("/doctor")
    public String showMainPageDoctor(){
        return "doctorMainPage";
    }

    @GetMapping("/card")
    public String findCard(@RequestParam(value = "id") Integer id, Model model) {
        CardDto card = cardService.findCard(id);
        model.addAttribute("card", card);
        return "cardDetailsForDoctor";
    }

    @GetMapping("/showAllDiagnoses")
    public String getAllDiagnoses(@RequestParam(value = "id") Integer id, Model model){
        CardSetDiagnosesDto cardSetDiagnosesDto = cardService.createCardSetDiagnosesDto(id);
        model.addAttribute("cardSetDiagnosesDto", cardSetDiagnosesDto);
        return "diagnoses";
    }

    @PostMapping("/updateCard")
    public String updateCard (@ModelAttribute CardSetDiagnosesDto cardSetDiagnosesDto,  Model model){
        CardDto card=cardService.save(cardSetDiagnosesDto);
        model.addAttribute("card",card);
        return "cardDetailsForDoctor";
    }


/*    @GetMapping("/showAllDiagnoses")
    public String getAllDiagnoses(@RequestParam(value = "id") Integer id, Model model){
        List<Diagnosis> diagnoses = diagnosisService.findAll();
        model.addAttribute("diagnoses", diagnoses);
        model.addAttribute("cardId", id);
        return "diagnoses";
    }

    @GetMapping("/updateCard")
    public String updateCard (@RequestParam List<Diagnosis> diagnoses, @RequestParam (name = "cardId") Integer id,  Model model){
       CardDto card = cardService.setDiagnosis(diagnoses,id);
       model.addAttribute("card",card);
        return "cardDetailsForDoctor";
    }*/


  /*  @PostMapping("/createDepartment")
    public String createEmployee(@ModelAttribute Department createDepartment, Model model){
        departmentService.save(createDepartment);

        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "department/department";
    }
*/



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
