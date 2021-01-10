package pl.coderslab.charity.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationModel {

    private  int quantity;
    private  List<Category> categories;
    private  Institution institution;
    private  String street;
    private  String city;
    private  String zipCode;
    private  String pickUpDate;
    private  String pickUpTime;
    private  String pickUpComment;
    private  String phone;

    public DonationModel() {
    }
    public Donation toDonationEntity( ){

        return new Donation(this.quantity, this.getCategories(), this.institution, this.street, this.city, this.zipCode, LocalDate.parse(this.pickUpDate), LocalTime.parse(this.pickUpTime), this.pickUpComment);
    }
}
