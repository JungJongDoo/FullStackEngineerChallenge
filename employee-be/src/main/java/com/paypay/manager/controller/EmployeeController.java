package com.paypay.manager.controller;

import com.paypay.manager.entity.Employee;
import com.paypay.manager.model.EmployeeRequest;
import com.paypay.manager.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping
    @ApiOperation(value = "従業員登録", notes = "従業員を登録する。")
    public ResponseEntity<Employee> create(@Validated @RequestBody EmployeeRequest employeeRequest) throws Exception {
        return ResponseEntity.ok(employeeService.registerEmployee(employeeRequest));
    }

    @GetMapping("/{no}")
    @ApiOperation(value = "個別従業員照会", notes = "個別従業員を照会する。")
    public ResponseEntity<Employee> read(@PathVariable(value = "no") Long no) throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeByNo(no));
    }

    @PutMapping("/{no}")
    @ApiOperation(value = "従業員更新", notes = "従業員を更新する。")
    public ResponseEntity<Employee> update(@PathVariable(value = "no") Long no,
                                           @Validated @RequestBody EmployeeRequest employeeRequest) throws Exception {
        return ResponseEntity.ok(employeeService.updateEmployee(no, employeeRequest));
    }

    @DeleteMapping("/{no}")
    @ApiOperation(value = "従業員削除", notes = "従業員を削除する。")
    public ResponseEntity<?> delete(@PathVariable(value = "no") Long no) throws Exception {
        employeeService.deleteEmployee(no);
        return ResponseEntity.noContent().build();
    }

}
