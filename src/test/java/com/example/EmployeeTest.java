package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class EmployeeTest {

    @Test
    void idUpdatesWhenNewIdSet(){
        Employee employee = new Employee("emp1", 30000);

        var result1 = employee.getId();
        employee.setId("emp3");

        assertEquals("emp1", result1);
        assertThat(employee.getId()).isEqualTo("emp3");
    }

    @Test
    void salaryChangesWhenSalaryIsUpdated(){
        Employee employee = new Employee("emp2", 40000);

        var result = employee.getSalary();
        employee.setSalary(25000);

        assertThat(result).isEqualTo(40000);
        assertThat(employee.getSalary()).isEqualTo(25000);
    }

    @Test
    void paidUpdatesWhenPaidIsUpdated(){
        Employee employee = new Employee("emp1", 20000);

        var result = employee.isPaid();
        employee.setPaid(true);

        assertFalse(result);
        assertTrue(employee.isPaid());
    }

    @Test
    void testToEquals(){
        Employee employee = new Employee("emp4", 50000);

        assertThat(employee.toString())
            .isEqualTo("Employee [id=emp4, salary=50000.0]");
    }
}