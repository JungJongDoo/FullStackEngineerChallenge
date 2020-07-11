import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeService} from '../employee.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  no: number;
  employee: Employee;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.no = this.route.snapshot.params['no'];
    this.employeeService.read(this.no)
      .subscribe(data => {
        this.employee = data;
      }, error => alert(JSON.stringify(error.error.message)));
  }

  gotoList() {
    this.router.navigate(['list']);
  }

}
