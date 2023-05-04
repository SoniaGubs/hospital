package com.academy.hospital.controller;

import com.academy.hospital.model.entity.Reception;
import com.academy.hospital.service.ReceptionService;
import com.academy.hospital.service.PatientService;
import com.academy.hospital.service.StaffService;
import com.academy.hospital.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final ReceptionService receptionService;
    private final PatientService patientService;
    private final StaffService staffService;
    private final TreatmentService treatmentService;


    @GetMapping("/allReceptions")
    public String getAll(Model model) {
        List <Reception> receptions = receptionService.findAll();
        model.addAttribute("allReceptions", receptions);
        return "allReceptions";
    }

    @GetMapping("/reception")
    public String findCard(@RequestParam(value = "id") Integer id, Model model){
        Reception reception = receptionService.findReception(id);
        model.addAttribute("reception", reception);
        return "receptionDetails";
    }


  /*  @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @GetMapping("/treatments")
    public List<Treatment> getAllTreatments() {
        return treatmentService.findAll();
    }

    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        return staffService.findAll();
    }*/

    @GetMapping("/sicks")
    public String getAllSick(Model model) {
        List <Reception> receptions = receptionService.findSick();
        model.addAttribute("sicks", receptions);
        return "sicks";

    }


}
