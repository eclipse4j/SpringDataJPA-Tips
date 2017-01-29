package com.tistory.eclipse4j.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistory.eclipse4j.jpa.entity.Company;
import com.tistory.eclipse4j.jpa.repository.CompanyRepository;

@Service
public class CompanyFindService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company findById(Long id) {
	return companyRepository.findOne(id);
    }
    
    public Company findColumnById(Long id) {
	return companyRepository.findColumnById(id);
    }
}
