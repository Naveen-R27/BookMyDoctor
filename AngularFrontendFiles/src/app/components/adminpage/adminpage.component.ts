import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/models/doctor';
import { Patient } from 'src/app/models/patient';
import { DoctorService } from 'src/app/services/doctor.service';
import { PatientService } from 'src/app/services/patient.service';
import { AppointmentService } from 'src/app/services/appointment.service';
import { Appointment } from 'src/app/models/appointment';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {

  showTable: boolean = false;
  showTable1: boolean = false;
  showTable2: boolean = false;


  doctors : Doctor[] | undefined;
  patients : Patient[] | undefined;
  appoint : Appointment[] | undefined

 // doctorid!:number;
  //doctor : Doctor = new Doctor();


  constructor(private appointservice:AppointmentService,private doctorservice:DoctorService, private patientservice:PatientService, private routes:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.getdoctors();
    this.getpatient();
    this.getappoinitment();
  }

  private getdoctors(){
    this.doctorservice.viewAlldoctor().subscribe(data => {
      this.doctors = data
    })
  }

  private getpatient(){
    this.patientservice.getUserList().subscribe(data =>{
      this.patients = data
    })
  }

  private getappoinitment(){
    this.appointservice.getBookingsList().subscribe(data =>{
      this.appoint = data
    })
  }
  
  toggleShowTable(): void {
    this.showTable = !this.showTable;
}

toggleShowTable1(): void {
  this.showTable1= !this.showTable1;
}

toggleShowTable2(): void {
  this.showTable2= !this.showTable2;
}

modifydoc(doctorId: number)
{
  this.routes.navigate(['updatedoc', doctorId],{skipLocationChange:true});
}



appointdoc(doctorId:number){
  this.routes.navigate(['addappoint',doctorId],{skipLocationChange:true});
}

removedoctor(doctorId:number){
  //this.doctor=new Doctor();
  //this.doctorid = this.route.snapshot.params['doctorid'];
  //this.doctorservice.removedoctor(this.doctorid).subscribe(data =>{
  //  alert("Deleted successfully")
  this.routes.navigate(['deldoc',doctorId],{skipLocationChange:true});
  
  
}

removepatient(patientId:number){
  this.routes.navigate(['deletepat', patientId],{skipLocationChange:true});
}

}
