package dk.almbrand.demo.partner.service;

import dk.almbrand.demo.partner.model.Company;
import dk.almbrand.demo.partner.model.Owner;
import dk.almbrand.demo.partner.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private CompanyRepository partnerRepository;

    @Override
    public List<Company> findAll() {
        return partnerRepository.findAll();
    }

    @Override
    public Company save(Company company) {
        for (Owner owner : company.getOwners()) {
            owner.getOwnsCompanies().add(company);
            owner.setCvr(company.getCvr());
        }

        return partnerRepository.save(company);
    }

    @Override
    public Optional<Company> findCompanyById(String cvr) {
        return partnerRepository.findById(cvr);
    }

    @Override
    public void deleteById(String cvr) {
        partnerRepository.deleteById(cvr);
    }

    @Override
    public void deleteAll() {
        partnerRepository.deleteAll();
    }
}