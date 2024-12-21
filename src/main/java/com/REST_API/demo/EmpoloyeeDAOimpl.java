package com.REST_API.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmpoloyeeDAOimpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional//отвечает за открытие и закрытие транзакций
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee")
                .getResultList();
        return allEmployees;
    }
}
