package com.paypay.manager.service;

import com.paypay.manager.entity.Employee;
import com.paypay.manager.model.EmployeeRequest;
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

    public Employee getEmployeeByNo(Long no) throws Exception {
        Employee employee = this.employeeRepository.findByNo(no);
        if (employee == null) {
            throw new Exception("存在しない従業員です。");
        }
        return employee;
    }

    public Employee registerEmployee(EmployeeRequest employeeRequest) throws Exception {
        checkEmail(employeeRequest.getEmail());

        Employee employee = new Employee();
        employee.setEmail(employeeRequest.getEmail());
        employee.setName(employeeRequest.getName());
        employee.setMobileNo(employeeRequest.getMobileNo());
        employee.setSex(employeeRequest.getSex());

        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long no, EmployeeRequest beforeEmployee) throws Exception {
        Employee employee = getEmployeeByNo(no);
        employee.setName(beforeEmployee.getName());
        employee.setMobileNo(beforeEmployee.getMobileNo());
        employee.setSex(beforeEmployee.getSex());
        this.employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(Long no) throws Exception {
        Employee employee = getEmployeeByNo(no);
        this.employeeRepository.delete(employee);
    }

    private void checkEmail(String email) throws Exception {
        Employee employee = this.employeeRepository.findByEmail(email);
        if (employee != null) {
            throw new Exception("既に存在するemailです。");
        }
    }
}
