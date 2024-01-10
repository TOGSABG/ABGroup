package dk.almbrand.demo.partner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "OWNERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    private String name;

    private String address;

    @Id
    private String cpr;

    private String cvr;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "owns_companies",
            joinColumns = @JoinColumn(name = "cpr"),
            inverseJoinColumns = @JoinColumn(name = "cvr")
    )
    //prevent the infinite recursion
    @JsonIgnore
    @ToString.Exclude
    private List<Company> ownsCompanies = new ArrayList<Company>();

}
