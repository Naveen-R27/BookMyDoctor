import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { of } from 'rxjs/internal/observable/of';
import { Patient } from 'src/app/models/patient';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  patient : Patient = new Patient();
  patients : Patient[] | undefined;

  constructor(private patientservice:PatientService,private routes :Router) { }

  ngOnInit(): void {
    //this.getpatient();
  }

  loginpatient(){
    this.patientservice.loginpatient(this.patient).subscribe(data => console.log("Response received"),
    error => console.log("Something went wrong")
    )

  }

  getpatient(){
    this.patientservice.getUserList().subscribe(data =>{
      this.patients = data
      const emails = (<HTMLInputElement>document.getElementById("email")).value;
      const passw = (<HTMLInputElement>document.getElementById("password")).value;
      //console.log(emails);
      let em = this.patients?.find(i => i.email === emails);
      console.log(em)
      //let ps = this.patients?.find(j => j.password === passw );;

  
      //console.log(this.patient);
      //var p = this.patient.selected.map(t=>t.email);
      //console.log(p);

      if(em?.email === emails && em.password === passw){
        console.log("its same");
        this.routes.navigate(['patientpage'],{skipLocationChange:true});
      }
      else{
        console.log("not same");
        window.location.reload();
      }

    })
  }

//email : string = "";
login(){
  const emails = (<HTMLInputElement>document.getElementById("email")).value;
  if(this.patients)
  console.log(emails);

}

}
