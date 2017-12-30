package com.tistory.eclipse4j.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Table 전체에 대한 select 와 특정 컬럼별 select
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFindServiceTest {

    @Autowired
    private CompanyFindService companyFindService;

    /**
     * 일반적인 전체 컬럼
     */
    @Test
    public void test_findById() {
        companyFindService.findById(0L);
    }

    /**
     * 특정 컬럼만 가져오도록 처리된 메소드
     */
    @Test
    public void test_findColumnById() {
        companyFindService.findColumnById(0L);
    }
}
