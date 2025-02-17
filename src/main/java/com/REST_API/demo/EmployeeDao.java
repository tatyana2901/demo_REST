package com.REST_API.demo;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
    public void saveEmployee(Employee employee);
    public void deleteEmployee(int id);
}
