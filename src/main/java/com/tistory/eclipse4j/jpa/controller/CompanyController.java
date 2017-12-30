package com.tistory.eclipse4j.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tistory.eclipse4j.jpa.domain.CompanyDto;
import com.tistory.eclipse4j.jpa.entity.Company;
import com.tistory.eclipse4j.jpa.service.CompanyCreateService;
import com.tistory.eclipse4j.jpa.service.CompanyFindService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyFindService companyFindService;
	@Autowired
	private CompanyCreateService companyCreateService;

	@ResponseBody
	@GetMapping(path = "/companies/{companyId}")
	public CompanyDto find(@PathVariable("companyId") Long companyId) {
		CompanyDto companyDto = companyFindService.findCacheDataById(companyId);
		return companyDto;
	}

	@ResponseBody
	@GetMapping(path = "/companies/{companyId}/update")
	public HttpStatus update(@PathVariable("companyId") Long companyId, @RequestParam("companyName")String companyName) {
		companyCreateService.updateById(companyId, companyName);
		return HttpStatus.OK;
	}

	@ResponseBody
	@GetMapping(path = "/companies/create")
	public HttpStatus save() {
		Company cacheReloadTestComplay = new Company();
		cacheReloadTestComplay.setCode("A00101");
		cacheReloadTestComplay.setName("Grissom.Kim");
		cacheReloadTestComplay.setStreetAddress("11 st.");
		companyCreateService.save(cacheReloadTestComplay);
		return HttpStatus.CREATED;
	}
}
