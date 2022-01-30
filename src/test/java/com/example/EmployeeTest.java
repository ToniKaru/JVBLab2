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



}