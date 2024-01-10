package dk.almbrand.demo.partner.controller;

import dk.almbrand.demo.partner.model.Company;
import dk.almbrand.demo.partner.model.Profitability;
import dk.almbrand.demo.partner.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @GetMapping("/companies/{cvr}")
    public ResponseEntity<Company> getCompanyByCvr(@PathVariable("cvr") String cvr) {
        Optional<Company> company = partnerService.findCompanyById(cvr);

        if (company.isPresent()) {
            //For demo purposes - Mock Profitability data - could be a REST GET call here, with lookup by cvr
            //Or could have been updated on the company from batch job before this
            Profitability profitability = Profitability.builder().cvr(company.get().getCvr()).revenue(1000.0).expenses(200.0).netprofit(800.0).build();
            company.get().setProfitability(profitability);
            return new ResponseEntity<>(company.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        try {
            Company _tutorial = partnerService.save(company);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/companies/{cvr}")
    public ResponseEntity<Company> updateCompany(@PathVariable("cvr") String cvr, @RequestBody Company company) {
        Optional<Company> companyData = partnerService.findCompanyById(cvr);

        if (companyData.isPresent()) {
            Company _company = companyData.get();
            _company.setAddress(company.getAddress());
            _company.setCvr(company.getCvr());
            _company.setOwners(company.getOwners());
            _company.setPhonenumber(company.getPhonenumber());
            return new ResponseEntity<>(partnerService.save(_company), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/companies/{cvr}")
    public ResponseEntity<HttpStatus> deleteCompany(@PathVariable("cvr") String cvr) {
        try {
            partnerService.deleteById(cvr);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
