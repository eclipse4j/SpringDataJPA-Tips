package com.tistory.eclipse4j.jpa.repository;

import com.tistory.eclipse4j.jpa.entity.SimpleCompany;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryImplTest {
    @Autowired
    private CompanyRepository companyRepository;
    
    @Test
    public void test_MaxID() {
        Long maxId = companyRepository.findMaxId();
        System.out.println(maxId);
    }

    @Test
    public void test_FindSimpleCompany() {
        SimpleCompany simpleCompany = companyRepository.findSimpleCompanyById(0L);
        System.out.println(simpleCompany);
    }
}
