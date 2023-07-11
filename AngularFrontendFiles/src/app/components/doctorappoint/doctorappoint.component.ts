import { Component, OnInit } from '@angular/core';
import { AppointmentService } from 'src/app/services/appointment.service';
import { Appointment } from 'src/app/models/appointment';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-doctorappoint',
  templateUrl: './doctorappoint.component.html',
  styleUrls: ['./doctorappoint.component.css']
})
export class DoctorappointComponent implements OnInit {
  docid!: number;
  //appoint : Appointment[] | undefined
  //booking : Appointment = new Appointment();
  booking :any;

  constructor(private routes:Router,private route:ActivatedRoute,private appointservice :AppointmentService) { }

  ngOnInit(): void {
  //this.booking=new Appointment();
  this.docid = this.route.snapshot.params['docid'];
  this.appointservice.getBooking(this.docid).subscribe(data =>{
    this.booking=data
    console.log(this.booking);
    //this.routes.navigate(['adminpage']);
    //alert("Deleted successfully")
  }, error => console.log(error));
  }

}
