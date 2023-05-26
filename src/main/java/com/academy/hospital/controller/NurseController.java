package com.academy.hospital.controller;

import com.academy.hospital.dto.CardDto;
import com.academy.hospital.dto.TreatmentDto;
import com.academy.hospital.exceptions.TreatmentException;
import com.academy.hospital.model.repository.UserRepository;
import com.academy.hospital.service.CardService;
import com.academy.hospital.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NurseController {

    private final CardService cardService;
    private final TreatmentService treatmentService;
    private final UserRepository userRepository;


    @GetMapping("/nurse/nurseMainPage")
    public String showNurseMainPage(Model model) {
        List<CardDto> cards = cardService.findSick();
        model.addAttribute("sicks", cards);
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
    public String doTreatment(@RequestParam Integer id, @RequestParam Integer cardId, @AuthenticationPrincipal UserDetails userDetails) throws TreatmentException {
        Integer userId = userRepository.findByUsername(userDetails.getUsername()).getId();
        treatmentService.doTreatment(id, userId);
        return "redirect:/nurse/card?id=" + cardId;
    }


}
