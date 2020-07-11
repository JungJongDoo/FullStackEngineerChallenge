import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import {EmployeeService} from '../employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService,
              private router: Router) { }

  ngOnInit() {
  }

  save() {
    this.employeeService.create(this.employee)
      .subscribe(data => this.gotoList(),
        error => alert(JSON.stringify(error.error.message)));
  }

  onSubmit() {
    if (!this.employeeService.isFormValid(this.employee)) {
      return false;
    }
    this.save();
  }

  gotoList() {
    this.router.navigate(['list']);
  }
}
