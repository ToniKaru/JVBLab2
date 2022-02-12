package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {
    Employee employee1 = new Employee("emp1", 30000);
    Employee employee2 = new Employee("emp2", 40000);
    static Employee employee3 = new Employee("emp3", 23000);
    static Employee employee4 = new Employee("emp4",55000);

    @Test
    void payEmployeeSuccessShouldPayAllAndMarkEachAsPaid(){
        List<Employee> employees = List.of(employee1,employee2);
        BankService bankServiceMock = mock(BankService.class);
        EmployeeRepository employeeRepoStub =
            new EmployeeRepositoryStub(employees);
        EmployeeManager employeeManager =
            new EmployeeManager(employeeRepoStub, bankServiceMock);

        var result = employeeManager.payEmployees();

        verify(bankServiceMock, times(employees.size())).pay(anyString(), anyDouble());
        assertEquals(employees.size(), result);
        assertTrue(employee1.isPaid());
    }

    @ParameterizedTest
    @MethodSource("employeeProvider")
    void payEmployeeFailureShouldMarkEachAsUnpaid(Employee employee){
        BankService bankServiceStub = new BankServiceStub();
        EmployeeRepository employeeRepoMock = mock(EmployeeRepository.class);
        when(employeeRepoMock.findAll()).thenReturn(getTwoEmployees());
        EmployeeManager manager =
            new EmployeeManager(employeeRepoMock,bankServiceStub);
        employee.setPaid(true);

        var result = manager.payEmployees();

        verify(employeeRepoMock, times(1)).findAll();
        assertEquals(0, result);
        assertFalse(employee.isPaid());
    }

    static Stream<Employee> employeeProvider() {
        return getTwoEmployees().stream();
    }

    static List<Employee> getTwoEmployees() {
        return List.of(employee3, employee4);
    }

}
