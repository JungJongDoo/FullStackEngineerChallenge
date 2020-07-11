import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeService} from '../employee.service';
import {Observable} from 'rxjs';
import {Review} from '../review';
import {ReviewService} from '../review.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  no: number;
  employee: Employee;
  reviews: Observable<Review[]>;
  review: Review = new Review();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private employeeService: EmployeeService,
              private reviewService: ReviewService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.no = this.route.snapshot.params['no'];
    this.employeeService.read(this.no)
      .subscribe(data => {
        this.employee = data;
      }, error => alert(JSON.stringify(error.error.message)));
    this.reviewRefresh();
  }

  reviewRefresh() {
    this.reviews = this.reviewService.list(this.no);
  }

  save() {
    this.reviewService.create(this.review)
      .subscribe(data => this.ngOnInit(),
        error => alert(JSON.stringify(error.error.message)));
    this.review = new Review();
  }

  onSubmit() {
    this.review.employeeNo = this.no;
    if (!this.reviewService.isFormValid(this.review)) {
      return false;
    }
    this.save();
  }

  delete(no: number) {
    this.reviewService.delete(no)
      .subscribe(
        data => {
          this.reviewRefresh();
        },
        error => alert(JSON.stringify(error.error.message)));
  }

  gotoList() {
    this.router.navigate(['list']);
  }

}
