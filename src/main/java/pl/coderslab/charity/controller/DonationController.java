package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("/donate")
    public String donationForm(){
        return "donationForm";
    }

    @ModelAttribute("categories")
    List<Category> categoryList(){
        return categoryService.getAllCategories();
    }

    @ModelAttribute("institutions")
    List<Institution> institutionsList(){
        return institutionService.getAllInstitutions();
    }
}
