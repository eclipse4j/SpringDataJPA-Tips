package com.tistory.eclipse4j.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistory.eclipse4j.jpa.domain.CompanyDto;
import com.tistory.eclipse4j.jpa.entity.Company;
import com.tistory.eclipse4j.jpa.repository.CompanyRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	//@Cacheable(cacheNames = "Company", key = "#id")
	public CompanyDto findCacheDataById(Long id) {
		log.info("Cacheable 처리 => {}", id);
		Company company = companyRepository.findOne(id);
		return CompanyDto.build(company);
	}
}
