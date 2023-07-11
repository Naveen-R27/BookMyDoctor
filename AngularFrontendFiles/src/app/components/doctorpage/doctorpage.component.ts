import { Component, OnInit } from '@angular/core';
import { PatientService } from 'src/app/services/patient.service';
import { Patient } from 'src/app/models/patient';
import { Router } from '@angular/router';
import { AppointmentService } from 'src/app/services/appointment.service';
import { Appointment } from 'src/app/models/appointment';

@Component({
  selector: 'app-doctorpage',
  templateUrl: './doctorpage.component.html',
  styleUrls: ['./doctorpage.component.css']
})
export class DoctorpageComponent implements OnInit {
  filteredString: string = '';
  showTable: boolean = false;
  showTable2 :boolean = false;
  patients : Patient[] | undefined;
  appoint : Appointment[] | undefined;

 // doc1 :number | undefined;
  docid: any;
  //appoint : Appointment[] | undefined

  constructor(private patientservice : PatientService,private routes :Router,private appointservice : AppointmentService) { }

  ngOnInit(): void {
    this.getpatient();
    this.getappoinitment();
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
  this.showTable2 = !this.showTable2;
}

onSubmit(){
  //return this.doctorid;
  //alert(doc);
  //doc1: number 
//this.doc1 = Number(doc);
console.log(this.docid);
this.routes.navigate(['doctorappoint',this.docid],{skipLocationChange:true});
 /* this.appointservice.getBooking(this.docid).subscribe(data =>{
  this.appoint = data
   this.showTable2 = !this.showTable2;
 })*/
  
  //console.log(doc);
}


}
