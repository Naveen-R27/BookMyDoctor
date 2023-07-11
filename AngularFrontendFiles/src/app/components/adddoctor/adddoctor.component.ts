import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/models/doctor';
import { Router } from '@angular/router';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.css']
})
export class AdddoctorComponent implements OnInit {

  doctors: Doctor={"doctorId":null, "doctorName":"", "speciality":"","location":"","hospitalName":"","mobileNo":"","email":"","password":"","chargedPerVisit": null};


  constructor(private adddoctorservice:DoctorService,private routes:Router) { }

  ngOnInit(): void {
  }

  addDoctor(){
    this.adddoctorservice.adddoctor(this.doctors).subscribe(data =>{
      alert("**** Doctor Added Successfully ***")
      this.routes.navigate(['adminpage'])
    },error=>alert("Sorry user not registered"));
    
  }

  goToadmin(){
    this.routes.navigate(['adminpage'])

  }

}
