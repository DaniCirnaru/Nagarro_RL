package com.nagarro.remotelearning.factory;

import com.nagarro.remotelearning.domain.Employee;
import com.nagarro.remotelearning.domain.Engine;
import com.nagarro.remotelearning.exception.UnqualifiedEmployeeException;
import com.nagarro.remotelearning.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class FactoryTest {

    private EmployeeService employeeService;
    private EngineFactory engineFactory;

    @BeforeEach
    void setUp() {
        employeeService = mock(EmployeeService.class);
        engineFactory = new EngineFactory(employeeService);
    }

    @Test
    void testManufactureEngines_ValidEmployee() {

        Employee employee = new Employee("John");
        when(employeeService.isAssemblyLineWorker(employee)).thenReturn(true);

        List<Engine> engines = engineFactory.manufactureEngines(2, employee);

        assertEquals(2, engines.size());

        verify(employeeService).isAssemblyLineWorker(employee);
    }

    @Test
    void testManufactureEngines_InvalidEmployee() {

        Employee employee = new Employee("Jane");
        when(employeeService.isAssemblyLineWorker(employee)).thenReturn(false);

        assertThrows(UnqualifiedEmployeeException.class, () ->
                engineFactory.manufactureEngines(1, employee));

        verify(employeeService).isAssemblyLineWorker(employee);
    }
    @Test
    void testManufactureEngines_OneEngine() {
        Employee employee = new Employee("John");
        when(employeeService.isAssemblyLineWorker(employee)).thenReturn(true);

        List<Engine> engines = engineFactory.manufactureEngines(1, employee);

        assertEquals(1, engines.size());

        verify(employeeService).isAssemblyLineWorker(employee);
    }

}
