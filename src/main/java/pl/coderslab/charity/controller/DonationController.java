package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.dto.DonationForm;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService,DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/donate")
    public String donationForm(){
        return "donationForm";
    }

    @PostMapping("/donate")
    public String donationFormProcess(@Valid @ModelAttribute("donation") DonationForm donationModel, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("donation", donationModel);
            model.addAttribute("formError", "Twój formularz zawiera błędy");
            return "donationForm";
        } else {
            donationService.save(donationModel.toDonationEntity());
            return "donationConfirmed";
        }


    }
    @ModelAttribute("categories")
    List<Category> categoryList(){
        return categoryService.getAllCategories();
    }

    @ModelAttribute("institutions")
    List<Institution> institutionsList(){
        return institutionService.getAllInstitutions();
    }

    @ModelAttribute("donation")
    DonationForm donation(){
            return new DonationForm();
        }
    }

