import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import {EmployeeService} from '../employee.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  employees: Observable<Employee[]>;

  constructor(private employeeService: EmployeeService,
              private router: Router) {}

  ngOnInit(): void {
    this.refresh();
  }

  refresh() {
    this.employees = this.employeeService.list();
  }

  create(){
    this.router.navigate(['create']);
  }

  update(no: number){
    this.router.navigate(['update', no]);
  }

  delete(no: number) {
    this.employeeService.delete(no)
      .subscribe(
        data => {
          this.refresh();
        },
        error => alert(JSON.stringify(error.error.message)));
  }

  detail(no: number){
    this.router.navigate(['detail', no]);
  }
}
