package com.tistory.eclipse4j.jpa.domain;

import java.util.function.Function;

import com.tistory.eclipse4j.jpa.entity.Employee;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeDto {

    private Long id;

    private String name;

    public static Function<Employee, EmployeeDto> convertEmployeeDto = new Function<Employee, EmployeeDto>() {
        @Override
        public EmployeeDto apply(Employee o){
            return EmployeeDto.builder().id(o.getId()).name(o.getName()).build();
        }
    };

}
