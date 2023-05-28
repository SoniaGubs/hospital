package com.academy.hospital.controller;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.StaffDto;
import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.exceptions.TreatmentException;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.StaffService;
import com.academy.hospital.service.TreatmentService;
import com.academy.hospital.service.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NurseController {

    private final CardService cardService;
    private final TreatmentService treatmentService;
    private final UserDetailsServiceImpl userDetailsService;
    private final StaffService staffService;


    @GetMapping("/nurse/mainPage")
    public String showNurseMainPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Integer userId = userDetailsService.findUserId(userDetails);
        StaffDto staffDto = staffService.findByUserId(userId);
        List<CardDto> cards = cardService.findSick();
        model.addAttribute("sicks", cards);
        model.addAttribute("staff", staffDto);
        return "nursePages/nurseMainPage";
    }

    @GetMapping("/nurse/card")
    public String findCard(@RequestParam(value = "id") Integer cardId, Model model) {
        CardDto card = cardService.findCard(cardId);
        List<TreatmentDto> treatmentsCompl = treatmentService.findCompletedTreatment(cardId);
        List<TreatmentDto> treatmentsNotCompl = treatmentService.findNotCompletedTreatment(cardId);
        model.addAttribute("card", card);
        model.addAttribute("treatmentsCompl", treatmentsCompl);
        model.addAttribute("treatmentsNotCompl", treatmentsNotCompl);
        return "nursePages/cardDetailsForNurse";
    }


    @GetMapping("/nurse/doTreatment")
    @ExceptionHandler()
    public String doTreatment(@RequestParam Integer id, @RequestParam Integer cardId, @AuthenticationPrincipal UserDetails userDetails) {
        Integer userId = userDetailsService.findUserId(userDetails);
        try {
            treatmentService.doTreatment(id, userId);
        } catch (TreatmentException e) {
            e.printStackTrace();
            return "redirect:/nurse/card?id=" + cardId;
        }
        return "redirect:/nurse/card?id=" + cardId;
    }
}