import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/api/employee';

  constructor(private http: HttpClient) { }

  list(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
