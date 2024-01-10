package dk.almbrand.demo.partner.controller;

import dk.almbrand.demo.partner.repository.CompanyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataRepositoryUnitTest {

    @Autowired
    CompanyRepository partnerRepository;

    @Test
    public void correctSetup_thenEntityManagerIsAvailable() {
        assertNotNull(partnerRepository);
    }
}