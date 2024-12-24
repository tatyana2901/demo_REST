package com.REST_API.demo;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public Employee getEmployee(int id);
}
