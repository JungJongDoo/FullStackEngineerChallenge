package com.paypay.manager.controller;

import com.paypay.manager.entity.Employee;
import com.paypay.manager.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ApiOperation(value = "従業員照会", notes = "全体従業員を照会する。")
    public List<Employee> list() {
        return employeeService.getAllEmployee();
    }

}
