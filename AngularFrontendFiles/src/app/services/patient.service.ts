import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseUrl='http://localhost:8086/patient';
  constructor(private http: HttpClient) { }

  createUser(user: object): Observable<Object>{
    return this.http.post(`${this.baseUrl}/addPatient`, user);
  }

  updateUser(user: object): Observable<Object>{
    return this.http.put(`${this.baseUrl}/updatePatient/`, user);
  }

  deleteUser(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/deletePatient/${id}`,{ responseType: 'text'});
  }

  getUser(userId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/viewPatient/${userId}`);
  }

  getUserList(): Observable<any>{
    return this.http.get(`${this.baseUrl}/allPatient`)
  }

loginpatient(user: object): Observable<any>{
  return this.http.post<any>(`${this.baseUrl}/PatientLogin`, user)
}

}
