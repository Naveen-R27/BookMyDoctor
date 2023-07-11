import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private Url = 'http://localhost:8086/doctor';
  constructor(private http: HttpClient) { }
  
  viewdoctorbyid(id: number): Observable<any> {
    return this.http.get(`${this.Url}/viewDoctor/${id}`);
  }

  adddoctor(doctor: Object): Observable<Object> {
    return this.http.post(`${this.Url}/addDoctor`, doctor);
  }

  modifydoctor(doctorId: number,value:any): Observable<Object> {
    return this.http.put(`${this.Url}/updateDoctor`, value);
  }

  removedoctor(doctorId: number): Observable<any> {
    return this.http.delete(`${this.Url}/deleteDoctor/${doctorId}`, { responseType: 'text' });
    //return this.http.delete('http://localhost:8086/doctor/deleteDoctor?doctorId='+doctorId);
    //return this.http.delete(`${this.Url}/deleteDoctor?doctorId=`+ doctorId, { responseType: 'text' });
  }

  viewAlldoctor(): Observable<any> {
    return this.http.get(`${this.Url}/allDoctor`);
  }

}
