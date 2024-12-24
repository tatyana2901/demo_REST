package com.REST_API.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {

        System.out.println("КОНСТРУКТОР СЕРВИСА РАБОТАЕТ");
    }


    @Transactional//отвечает за открытие и закрытие транзакций
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }


}
