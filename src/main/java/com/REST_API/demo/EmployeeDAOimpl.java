package com.REST_API.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDao {
    /*   @Autowired
       private SessionFactory sessionFactory;*/
    @Autowired
    private EntityManager entityManager; //JPA объект ; session factory - объект hibernate

    @Override
    public List<Employee> getAllEmployees() {
        /*Функционал hibernate: Session session = entityManager.unwrap(Session.class); - Получить session из entity manager
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList(); - hibernate*/
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList(); //функционал jpa
        return allEmployees;
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee employee) {//hibernate: save or update - сохранить или обновить
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId()); //чтобы в postman в разделе request видеть информацию об id - не 0, а актуальный id
    }

    @Override
    public void deleteEmployee(int idParam) {
       Query query =  entityManager.createQuery("delete from Employee where id =:employeeId");
       query.setParameter("employeeId",idParam);
       query.executeUpdate();

    }


}
