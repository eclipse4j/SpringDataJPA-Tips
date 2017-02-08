package com.tistory.eclipse4j.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tistory.eclipse4j.jpa.entity.Company;
import com.tistory.eclipse4j.jpa.service.CompanyFindService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyFindService companyFindService;

	@ResponseBody
	@GetMapping(path = "/companies/{companyId}")
	public Company find(@PathVariable("companyId") Long companyId) {
		Company company = companyFindService.findCacheDataById(companyId);
		return company;
	}

}
