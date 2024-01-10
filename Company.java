package dk.almbrand.demo.partner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "COMPANY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private String address;
    private String phonenumber;

    @Id
    private String cvr;
    @OneToMany(mappedBy = "ownsCompanies", cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Owner> owners = new ArrayList<>();

    @Transient
    private Profitability profitability;

}