package com.tistory.eclipse4j.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.tistory.eclipse4j.jpa.entity.Company;

public interface CompanyRepository extends CompanyRepositoryCustom, JpaRepository<Company, Long>, QueryDslPredicateExecutor<Company> {

    @Query("select new Company(o.code) from Company o where o.id = :id")
    Company findColumnById(@Param("id") Long id);
}
