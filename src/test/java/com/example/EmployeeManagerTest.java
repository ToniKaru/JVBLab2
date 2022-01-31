package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {
    Employee employee1 = new Employee("emp1", 30000);
    Employee employee2 = new Employee("emp2", 40000);

    @Test
    void payEmployeeSuccessShouldPayEachEmployeeAndMarkEachAsPaid(){
        BankService bankServiceMock = mock(BankService.class);
        EmployeeRepository employeeRepoStub =
            new EmployeeRepositoryStub(List.of(employee1,employee2));
        EmployeeManager employeeManager = new EmployeeManager(employeeRepoStub, bankServiceMock);

        var result = employeeManager.payEmployees();

        verify(bankServiceMock, times(2)).pay(anyString(), anyDouble());
        assertEquals(2, result);
        assertTrue(employee1.isPaid());
        assertTrue(employee2.isPaid());
    }
}
