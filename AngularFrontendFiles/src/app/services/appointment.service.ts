import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private baseUrl = 'http://localhost:8086/appointment';
  constructor(private http: HttpClient) { }

  getBooking(bookingId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewAppointment/${bookingId}`);
  }

  createBooking(booking: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/addAppointment`, booking);
  }

  updateBooking(booking: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/updateAppointment`, booking);
  }

  deleteBooking(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteAppointment/${id}`, { responseType: 'text' });
  }

  getBookingsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/allAppointment`);
  }
}
