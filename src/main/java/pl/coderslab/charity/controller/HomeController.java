package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/home")
    public String homeAction() {
        return "index";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.getAllInstitutions();
    }

    @ModelAttribute("bags")
    public Long getBags() {
        return donationService.getAllBags();
    }

    @ModelAttribute("donations")
    public Long getAmountOfDonations(){
        return donationService.getAllDonations();
    }
}
