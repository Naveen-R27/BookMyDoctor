import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/models/doctor';
import { DoctorService } from 'src/app/services/doctor.service';
import { Appointment } from 'src/app/models/appointment';
import { AppointmentService } from 'src/app/services/appointment.service';



@Component({
  selector: 'app-addbooking',
  templateUrl: './addbooking.component.html',
  styleUrls: ['./addbooking.component.css']
})
export class AddbookingComponent implements OnInit {
 doctorid!: number;
 doctors : Doctor = new Doctor();

  booking : Appointment={"appointmentId": null ,"doctorId":null,"appointmentDate":"","doctorName":""};
  //booking : Appointment = new Appointment();



  constructor(private doctorsevice : DoctorService,private appointservice:AppointmentService,private route:ActivatedRoute,private routes:Router) { }

  ngOnInit(): void {
    this.doctors=new Doctor();
    this.doctorid = this.route.snapshot.params['doctorid'];
    this.doctorsevice.viewdoctorbyid(this.doctorid).subscribe(data =>{
      this.doctors = data;
      alert(" Appointment will be Booked For Doctor with ID --> "+this.doctorid +" "+this.doctors.doctorName)
    }, error => console.log(error));

  }

  addappoint(){
    this.appointservice.createBooking(this.booking).subscribe(data => {
      alert("***** Appointment Has Been Booked ******")
      this.routes.navigate(['patientpage'])

    }, error => console.log(error));
    
  }

  goToadmin(){
    this.routes.navigate(['adminpage'])

  }

}
