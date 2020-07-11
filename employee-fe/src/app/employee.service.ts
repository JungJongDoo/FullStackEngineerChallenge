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

  create(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  read(no: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${no}`);
  }

  update(no: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${no}`, value);
  }

  delete(no: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${no}`, { responseType: 'text' });
  }

  isFormValid(employee) {
    if (employee.name == undefined || employee.name.length > 110 ) {
      alert('お名前は110文字以下で入力してください。');
      return false;
    }
    if (employee.email == undefined || employee.email.length > 100 ) {
      alert('メールアドレスは100文字以下で入力してください。');
      return false;
    }
    if (employee.mobileNo == undefined || employee.mobileNo.length > 50 ) {
      alert('電話番号は50文字以下で入力してください。');
      return false;
    }
    if (employee.sex == undefined) {
      alert('性別を選択してください。');
      return false;
    }

    return true;
  }
}
