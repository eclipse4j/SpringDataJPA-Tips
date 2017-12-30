package com.tistory.eclipse4j.jpa.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.tistory.eclipse4j.jpa.entity.Company;
import com.tistory.eclipse4j.jpa.entity.QCompany;

public class CompanyRepositoryImpl extends QueryDslRepositorySupport implements CompanyRepositoryCustom {

    public CompanyRepositoryImpl() {
        super(Company.class);
    }

    @Override
    public Long findMaxId() {
        return from(QCompany.company).select(QCompany.company.id.max()).fetchOne();
    }

}
