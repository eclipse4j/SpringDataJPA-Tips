package com.tistory.eclipse4j.jpa.repository;

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
}
