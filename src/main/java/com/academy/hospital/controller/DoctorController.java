package com.academy.hospital.controller;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.CardSetDiagnosesDto;
import com.academy.hospital.dto.DiagnosisDto;
import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.service.DiagnosisService;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DoctorController {

    private final CardService cardService;
    private final DiagnosisService diagnosisService;
    private final TreatmentService treatmentService;

    @GetMapping("/doctor")
    public String showMainPageDoctor() {
        return "doctorPages/doctorMainPage";
    }

    @GetMapping("/card")
    public String findCard(@RequestParam(value = "id") Integer id, Model model) {
        CardDto card = cardService.findCard(id);
        List<TreatmentDto> treatmentsCompl = treatmentService.findCompletedTreatment(id);
        List<TreatmentDto> treatmentsNotCompl = treatmentService.findNotCompletedTreatment(id);
        model.addAttribute("card", card);
        model.addAttribute("treatmentsCompl", treatmentsCompl);
        model.addAttribute("treatmentsNotCompl", treatmentsNotCompl);
        return "doctorPages/cardDetailsForDoctor";
    }

    /*------------------------*/
    //Set or update diagnoses
    /*------------------------*/

    @GetMapping("/showAllDiagnoses")
    public String getAllDiagnoses(@RequestParam(value = "id") Integer id, Model model) {
        CardSetDiagnosesDto cardSetDiagnosesDto = cardService.createCardSetDiagnosesDto(id);
        List<DiagnosisDto> diagnosisDtos = diagnosisService.findAll();
        model.addAttribute("cardSetDiagnosesDto", cardSetDiagnosesDto);
        model.addAttribute("allDiagnoses", diagnosisDtos);
        return "doctorPages/diagnoses";
    }

    @PostMapping("/updateCard")
    public String updateCard(@ModelAttribute CardSetDiagnosesDto cardSetDiagnosesDto, Model model) {
        CardDto card = cardService.updateDiagnosis(cardSetDiagnosesDto);
        List<TreatmentDto> treatmentsCompl = treatmentService.findCompletedTreatment(card.getId());
        List<TreatmentDto> treatmentsNotCompl = treatmentService.findNotCompletedTreatment(card.getId());
        model.addAttribute("treatmentsCompl", treatmentsCompl);
        model.addAttribute("treatmentsNotCompl", treatmentsNotCompl);
        model.addAttribute("card", card);
        return "doctorPages/cardDetailsForDoctor";
    }

    /*------------------------*/
    // Set or update treatments
    /*------------------------*/

    @GetMapping("/addNewTreatment")
    public String addNewTreatment(@RequestParam(value = "cardId") Integer id, Model model) {
        TreatmentDto treatmentNew = new TreatmentDto();
        treatmentNew.setCard(cardService.findCard(id));
        model.addAttribute("treatment", treatmentNew);
        return "doctorPages/createUpdateTreatment";
    }

    @GetMapping("/updateTreatment")
    public String updateTreatment(@RequestParam Integer id, Model model) {
        TreatmentDto treatmentDto = treatmentService.findById(id);
        model.addAttribute("treatment", treatmentDto);
        return "doctorPages/createUpdateTreatment";
    }

    @PostMapping("/createTreatment")
    public String createTreatment(@ModelAttribute TreatmentDto treatment, Model model) {
        treatmentService.save(treatment);

        Integer cardId = treatment.getCard().getId();
        CardDto card = cardService.findCard(cardId);
        List<TreatmentDto> treatmentsCompl = treatmentService.findCompletedTreatment(cardId);
        List<TreatmentDto> treatmentsNotCompl = treatmentService.findNotCompletedTreatment(cardId);
        model.addAttribute("treatmentsCompl", treatmentsCompl);
        model.addAttribute("treatmentsNotCompl", treatmentsNotCompl);
        model.addAttribute("card", card);
        return "doctorPages/cardDetailsForDoctor";
    }





}
