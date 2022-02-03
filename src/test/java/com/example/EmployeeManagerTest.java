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

    @Test
    void payEmployeeShouldFailWhenBankServiceCannotCompleteTransaction(){
        BankService bankServiceStub = new BankServiceStub();
        EmployeeRepository employeeRepoMock = mock(EmployeeRepository.class);
        when(employeeRepoMock.findAll())
            .thenReturn(List.of(employee1,employee2));
        employee1.setPaid(true);
        employee2.setPaid(true);
        EmployeeManager manager = new EmployeeManager(employeeRepoMock,bankServiceStub);

        var result = manager.payEmployees();

        verify(employeeRepoMock, times(1)).findAll();
        assertEquals(0, result);
        assertFalse(employee1.isPaid());
        assertFalse(employee2.isPaid());
    }
}
