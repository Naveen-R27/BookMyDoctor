import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/models/patient';
import { Router } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  patients: Patient={"patientId": null,"patientName":"","mobileNo":"","password":"","email":"","bloodGroup":"","gender":"","age":"","address":""};

  constructor(private patientService:PatientService ,private routes:Router) { }

  ngOnInit(): void {
  }

  registeruser(){
    console.log(this.patients);
    this.patientService.createUser(this.patients).subscribe(data=>{
      alert("Successfully User regitered")
      this.routes.navigate(['home'])
    },error=>alert("Sorry user not registered"));
  }

  patientpages(){
    this.routes.navigate(['patientpage'],{skipLocationChange:true});
  }

}
