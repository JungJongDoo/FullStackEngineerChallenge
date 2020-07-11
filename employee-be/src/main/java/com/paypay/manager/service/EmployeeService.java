package com.paypay.manager.service;

import com.paypay.manager.entity.Employee;
import com.paypay.manager.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }
}
