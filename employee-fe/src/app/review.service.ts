import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private baseUrl = 'http://localhost:8080/api/review';

  constructor(private http: HttpClient) { }

  list(no: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${no}`);
  }

  create(review: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, review);
  }

  delete(no: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${no}`, { responseType: 'text' });
  }

  isFormValid(review) {
    if (review.contents == undefined || review.contents.length > 1000 ) {
      alert('内容は1000文字以下で入力してください。');
      return false;
    }

    return true;
  }
}
