import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/models/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doclogin',
  templateUrl: './doclogin.component.html',
  styleUrls: ['./doclogin.component.css']
})
export class DocloginComponent implements OnInit {
  doctor : Doctor = new Doctor();
  doctors : Doctor[] | undefined;

  notloggedin :boolean =false;
  

  constructor(private doctorservice :DoctorService,private routes :Router) { }

  ngOnInit(): void {
  }


  getdoctors(){
    this.doctorservice.viewAlldoctor().subscribe(data =>{
      this.doctors = data;

      const emails = (<HTMLInputElement>document.getElementById("email")).value;
      const passw = (<HTMLInputElement>document.getElementById("password")).value;

      let em = this.doctors?.find((i) => i.email === emails);
      //let pass = this.doctors?.find(j => j.email === emails);
      //console.log(this.doctors)
      //console.log(emails)
      //console.log(em?.email);
      /*if(em !== undefined){
        console.log(em);

      }*/


      if(em?.email === emails && em.password === passw){
        console.log("its same");
        this.routes.navigate(['doctorpage'],{skipLocationChange:true});
      }
      else{
        console.log("not same");
        alert("********* BAD CREDENTIALS CHECK EMAIL OR PASSWORD *********")
      
        window.location.reload();
      }

    })
  }

}
