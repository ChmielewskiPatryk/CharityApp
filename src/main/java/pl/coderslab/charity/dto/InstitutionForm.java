package pl.coderslab.charity.dto;


import lombok.Data;
import pl.coderslab.charity.entity.Institution;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class InstitutionForm {

    @NotEmpty(message ="Podaj nazwę fundacji")
    private String name;
    @NotEmpty(message ="Podaj opis fundacji")
    private String description;

    public InstitutionForm() {
    }

    public Institution toInstitution(InstitutionForm institutionForm){
        return new Institution(institutionForm.name, institutionForm.description);
    }
}
