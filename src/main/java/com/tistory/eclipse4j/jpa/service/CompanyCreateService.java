package com.tistory.eclipse4j.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistory.eclipse4j.jpa.entity.Company;
import com.tistory.eclipse4j.jpa.repository.CompanyRepository;

@Service
public class CompanyCreateService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company save(Company company){
        return companyRepository.save(company);
    }

    public Company updateById(Long companyId, String name){
        Company orgCompany = companyRepository.findOne(companyId);
        orgCompany.setName(name);
        return companyRepository.save(orgCompany);
    }
}
