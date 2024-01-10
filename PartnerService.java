package dk.almbrand.demo.partner.service;

import dk.almbrand.demo.partner.model.Company;

import java.util.List;
import java.util.Optional;

public interface PartnerService {
    List<Company> findAll();

    Company save(Company company);

    Optional<Company> findCompanyById(String cvr);


    void deleteById(String cvr);

    void deleteAll();

}
