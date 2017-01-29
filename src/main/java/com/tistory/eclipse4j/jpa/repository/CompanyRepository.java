package com.tistory.eclipse4j.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tistory.eclipse4j.jpa.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("select new Company(o.code) from Company o where o.id = :id")
    Company findColumnById(@Param("id")Long id);
}
