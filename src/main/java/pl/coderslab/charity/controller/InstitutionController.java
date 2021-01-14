package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstitutionController {


    @GetMapping("/editInstitutions")
    public String getInstitutionsList(){
        return "EditInstitutions";
    }
}
