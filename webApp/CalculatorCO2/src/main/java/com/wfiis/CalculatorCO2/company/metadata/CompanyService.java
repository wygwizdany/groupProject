package com.wfiis.CalculatorCO2.company.metadata;

import com.wfiis.CalculatorCO2.company.exceptions.CompanyNotCouldBeFound;
import com.wfiis.CalculatorCO2.company.metadata.entity.Company;
import com.wfiis.CalculatorCO2.company.metadata.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company saveCompany(Company company) {


        return companyRepository.save(company);
    }

    public Company findCompany(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotCouldBeFound(companyId));
    }
}
