package com.nagarro.remotelearning.factory;

import com.nagarro.remotelearning.domain.Employee;
import com.nagarro.remotelearning.domain.Engine;
import com.nagarro.remotelearning.domain.EngineArchitecture;
import com.nagarro.remotelearning.domain.EngineComponent;
import com.nagarro.remotelearning.exception.InsufficientStockException;
import com.nagarro.remotelearning.exception.UnauthorizedEmployeeException;
import com.nagarro.remotelearning.exception.UnqualifiedEmployeeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    private List<Employee> employees;
    private List<EngineComponent> engineComponents;
    private EngineFactory engineFactory;

    @BeforeEach
    void setUp() {
        employees = new ArrayList<>();
        employees.add(new Employee("John", false, true));
        employees.add(new Employee("Max", false, false));

        engineComponents = new ArrayList<>();
        engineComponents.add(new EngineComponent("Component1", 20));
        engineComponents.add(new EngineComponent("Component2", 20));
        engineComponents.add(new EngineComponent("Component3", 20));

        engineFactory = new EngineFactory(employees, engineComponents);
    }

    @Test
    void testBuildEngine() {
        Engine engine = new Engine(EngineArchitecture.L4, 2.0, 210);
        assertNotNull(engine);
        assertEquals(EngineArchitecture.L4, engine.getEngineArchitecture());
        assertEquals(2.0, engine.getDisplacement());
        assertEquals(210, engine.getHorsePower());
    }
    @Test
    void testEmployee() {

        assertNotNull(employees.get(1));
        assertEquals("Max", employees.get(1).getName());
        assertEquals(false, employees.get(1).isAssemblyLineWorker());
        assertEquals(false, employees.get(1).isAdministrator());
    }
    @Test
    void testComponent() {

        assertNotNull(engineComponents.get(2));
        assertEquals("Component3", engineComponents.get(2).getName());
        assertEquals(20, engineComponents.get(2).getWeight());
    }

    @Test
    void testQualificationEmployee() {
        assertTrue(employees.get(0).isAssemblyLineWorker());
    }

    @Test
    void testNoQualificationEmployee() {
        assertFalse(employees.get(1).isAssemblyLineWorker());
    }

    @Test
    void testEnoughComponentsInStock_True() {
        int numberComponents = engineComponents.size();
        int numberComponentsRequired = EngineFactory.getComponentsPerEngine();
        assertTrue(numberComponents >= numberComponentsRequired);
    }

    @Test
    void testEnoughComponentsInStock_False() {
        engineComponents.clear();
        int numberComponents = engineComponents.size();
        int numberComponentsRequired = EngineFactory.getComponentsPerEngine();
        assertTrue(numberComponents < numberComponentsRequired);
    }

    @Test
    void testManufactureEngines_SufficientComponents() {
        List<Engine> engines = engineFactory.manufactureEngines(1, employees.get(0));
        assertEquals(1, engines.size());
    }

    @Test
    void testManufactureEngines_InsufficientComponents() {
        assertThrows(InsufficientStockException.class, () ->
                engineFactory.manufactureEngines(5, employees.get(0)));
    }

    @Test
    void testManufactureEngines_UnauthorizedEmployee() {
        Employee unauthorizedEmployee = new Employee("Unauthorized", true, true);
        assertThrows(UnauthorizedEmployeeException.class, () ->
                engineFactory.manufactureEngines(1, unauthorizedEmployee));
    }

    @Test
    void testManufactureEngines_UnqualifiedEmployee() {
        assertThrows(UnqualifiedEmployeeException.class, () ->
                engineFactory.manufactureEngines(1, employees.get(1)));
    }
}
