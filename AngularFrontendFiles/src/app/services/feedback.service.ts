import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private Url = 'http://localhost:8086/feedback';
  constructor(private http: HttpClient) { }


  addfeedback(feedback: Object): Observable<Object> {
    return this.http.post(`${this.Url}/addFeedback`, feedback);
  }


}
