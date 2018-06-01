package com.tistory.eclipse4j.jpa.repository;

import com.tistory.eclipse4j.jpa.entity.SimpleCompany;

import java.util.List;

public interface CompanyRepositoryCustom {
    Long findMaxId();

    SimpleCompany findSimpleCompanyById(Long id);

    List<SimpleCompany> findSimpleCompanies();
}
