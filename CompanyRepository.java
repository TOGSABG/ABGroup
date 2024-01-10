package dk.almbrand.demo.partner.repository;

import dk.almbrand.demo.partner.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Great help by JpaRepository makes CRUD operations and custom finder methods without boilerplate code.
basic CRUD operations and also pagination and sorting.
 */

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}