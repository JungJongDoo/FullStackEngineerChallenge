import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeService} from '../employee.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  no: number;
  employee: Employee;

  constructor(private route: ActivatedRoute,private router: Router,
              private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.no = this.route.snapshot.params['no'];
    this.employeeService.read(this.no)
      .subscribe(data => {
        this.employee = data;
      }, error => alert(JSON.stringify(error.error.message)));
  }

  update() {
    this.employeeService.update(this.no, this.employee)
      .subscribe(data => this.gotoList(), error => alert(JSON.stringify(error.error.message)));
  }

  onSubmit() {
    if (!this.employeeService.isFormValid(this.employee)) {
      return false;
    }
    this.update();
  }

  gotoList() {
    this.router.navigate(['list']);
  }

}
