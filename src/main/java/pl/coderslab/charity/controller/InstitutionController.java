package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.InstitutionForm;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InstitutionController {

    @ModelAttribute
    public InstitutionForm institutionForm(){
        return new InstitutionForm();
    }
    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/institutions")
    public String getInstitutionsList(Model model){
        List<Institution> institutions = institutionService.getAllInstitutions();
        model.addAttribute("institutiions", institutions);
        return "EditInstitutions";
    }

    @PostMapping("/institutions")
    public String addInstitution(@Valid  InstitutionForm institutionForm, BindingResult bindingResult,Model model) {
        if (!bindingResult.hasErrors()) {
            institutionService.save(institutionForm.toInstitution(institutionForm));
        }
        return "redirect:/institutions";

    }
    @GetMapping("/deleteInstitution/{id}")
    public String deleteInstitution(@PathVariable String id){
        institutionService.delete(Long.parseLong(id));
        return "redirect:/institutions";
    }

}
