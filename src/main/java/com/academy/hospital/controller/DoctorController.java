package com.academy.hospital.controller;

import com.academy.hospital.dto.*;
import com.academy.hospital.model.entity.Role;
import com.academy.hospital.model.repository.UserRepository;
import com.academy.hospital.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DoctorController {

    private final CardService cardService;
    private final DiagnosisService diagnosisService;
    private final TreatmentService treatmentService;

    private final StaffService staffService;
    private final UserRepository userRepository;


    @GetMapping("/doctor/doctorMainPage")
    public String showMainPageDoctor(Model model) {
        List<CardDto> cards = cardService.findSick();
        model.addAttribute("sicks", cards);
        return "doctorPages/doctorMainPage";

    }

    @GetMapping("/doctor/card")
    public String getCards(@RequestParam(value = "id") Integer cardId, Model model) {
        CardDto card = cardService.findCard(cardId);
        List<TreatmentDto> treatmentsCompl = treatmentService.findCompletedTreatment(cardId);
        List<TreatmentDto> treatmentsNotCompl = treatmentService.findNotCompletedTreatment(cardId);

        model.addAttribute("card", card);
        model.addAttribute("treatmentsCompl", treatmentsCompl);
        model.addAttribute("treatmentsNotCompl", treatmentsNotCompl);
        return "doctorPages/cardDetailsForDoctor";
    }

    /*-------------------------*/
    //  Set or update diagnoses
    /*-------------------------*/

    @GetMapping("/doctor/showAllDiagnoses")
    public String getAllDiagnoses(@RequestParam Integer id, Model model) {
        CardSetDiagnosesDto cardSetDiagnosesDto = cardService.createCardSetDiagnosesDto(id);
        List<DiagnosisDto> diagnosisDtos = diagnosisService.findAll();
        model.addAttribute("cardSetDiagnosesDto", cardSetDiagnosesDto);
        model.addAttribute("allDiagnoses", diagnosisDtos);
        return "doctorPages/diagnoses";
    }

    @PostMapping("/doctor/setDiagnosis")
    public String setDiagnosis(@ModelAttribute CardSetDiagnosesDto cardSetDiagnosesDto, Model model) {
        CardDto card = cardService.updateDiagnosis(cardSetDiagnosesDto);
        Integer id = card.getId();
        return "redirect:/doctor/card?id=" + id;
    }

    /*------------------------------*/
    // Set, update, delete, do treatment
    /*------------------------------*/

    @GetMapping("/doctor/addNewTreatment")
    public String createNewTreatment(@RequestParam(value = "cardId") Integer id, Model model) {
        TreatmentDto treatmentNew = new TreatmentDto();
        treatmentNew.setCard(cardService.findCard(id));
        model.addAttribute("treatment", treatmentNew);
        return "doctorPages/createUpdateTreatment";
    }

    @GetMapping("/doctor/updateTreatment")
    public String updateTreatment(@RequestParam Integer id, Model model) {
        TreatmentDto treatmentDto = treatmentService.findById(id);
        model.addAttribute("treatment", treatmentDto);
        return "doctorPages/createUpdateTreatment";
    }

    @PostMapping("/doctor/createTreatment")
    public String saveTreatment(@ModelAttribute TreatmentDto treatment) {
        treatmentService.save(treatment);
        Integer cardId = treatment.getCard().getId();
        return "redirect:/doctor/card?id=" + cardId;
    }

    @GetMapping("/doctor/deleteTreatment")
    public String deleteTreatment(@RequestParam Integer id, @RequestParam Integer cardId) {
        treatmentService.deleteTreatment(id);
        return "redirect:/doctor/card?id=" + cardId;
    }

    @GetMapping("/doctor/doTreatment")
    public String doTreatment(@RequestParam Integer id, @RequestParam Integer cardId, @AuthenticationPrincipal UserDetails userDetails) {
        Integer userId = userRepository.findByUsername(userDetails.getUsername()).getId();
        treatmentService.doTreatment(id, userId);
        return "redirect:/doctor/card?id=" + cardId;
    }

    /*------------------------------*/
    // medical history
    /*------------------------------*/

    @GetMapping("/doctor/showMedicalHistory")
    public String showMedicalHistory(@RequestParam Integer id, Model model) {
        List<CardDto> card = cardService.findAllCardByPatient(id);
        model.addAttribute("allPatientsCards", card);
        return "doctorPages/medicalHistory";
    }

    @GetMapping("/doctor/showDetailsMedicalHistory/{id}")
    public String getTreatmentsDetail(@PathVariable Integer id, Model model) {
        List<TreatmentDto> treatmentsCompl = treatmentService.findCompletedTreatment(id);
        model.addAttribute("treatmentsCompl", treatmentsCompl);
        return "doctorPages/detailsMedicalHistory";
    }


    /*------------------------------*/
    //  set doctor
    /*------------------------------*/


    @GetMapping("/doctor/showSetDoctor")
    public String showSetDoctor(@RequestParam Integer id, Model model) {
        List<StaffDto> doctors = staffService.findByRole(Role.ROLE_DOCTOR);
        model.addAttribute("cardId", id);
        model.addAttribute("doctors", doctors);
        return "doctorPages/setDoctor";
    }

    @GetMapping("/doctor/setDoctor")
    public String setDoctor(@RequestParam Integer staffId, @RequestParam Integer cardId) {
        CardDto cardDto = cardService.findCard(cardId);
        cardService.setDoctor(cardDto, staffId);
        return "redirect:/doctor/card?id=" + cardId;
    }


    /*------------------------------*/
    // Discharge
    /*------------------------------*/

    @GetMapping("/doctor/goToDischarge")
    public String showDischargePage(@RequestParam Integer id, Model model) {
        CardDto cardDto = cardService.findCard(id);
        cardDto.setDateOfDischarge(LocalDate.now());
        List<TreatmentDto> treatmentsCompl = treatmentService.findCompletedTreatment(id);
        model.addAttribute("treatmentsCompl", treatmentsCompl);
        model.addAttribute("card", cardDto);
        return "doctorPages/discharge";
    }

    @GetMapping("/doctor/discharge")
    public String discharge(@RequestParam Integer id, Model model) {
        cardService.discharge(id);
        return "redirect:/doctor/doctorMainPage";
    }



  /*  @GetMapping("/goToDischarge")
    public String goToDischarge(@RequestParam Integer id, Model model) {
           CardDto cardDto = cardService.findCard(id);
        if((cardDto.getDiagnoses())==null || cardDto.getStaff()==null){
            return "redirect:/card?id=" + id;
        }else{
            cardService.discharge(cardDto);
            return "sicks";
        }
    }
*/


}
