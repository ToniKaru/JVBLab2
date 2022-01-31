package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {

    public List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoryStub(){}

    public EmployeeRepositoryStub(List<Employee> employees){
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
