package pl.coderslab.charity.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationForm {
    @NotNull(message = "Podaj ilość")
    private  int quantity;
    @NotEmpty(message = "Wybierz przynajmniej jedną kategorię")
    private  List<Category> categories;
    @NotNull(message = "Wybierz jedną instytucję")
    private  Institution institution;
    @NotEmpty(message = "Podaj nazwę ulicy")
    private  String street;
    @NotEmpty(message = "Podaj nazwę miasta")
    private  String city;
    @NotEmpty(message = "Podaj kod pocztowy")
    private  String zipCode;
    @NotNull(message = "Podaj datę")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  LocalDate pickUpDate;
    @NotNull(message = "Podaj godzinę")
    private  LocalTime pickUpTime;
    private  String pickUpComment;
    @NotEmpty(message = "Podaj numer telefonu")
    private  String phone;

    public DonationForm() {
    }
    public Donation toDonationEntity( ){
        return new Donation(this.quantity, this.getCategories(), this.institution, this.street, this.city, this.zipCode, this.pickUpDate, this.pickUpTime, this.pickUpComment);
    }
}
