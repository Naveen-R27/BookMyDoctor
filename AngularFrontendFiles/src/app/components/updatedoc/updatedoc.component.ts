import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/models/doctor';
import { DoctorService } from 'src/app/services/doctor.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updatedoc',
  templateUrl: './updatedoc.component.html',
  styleUrls: ['./updatedoc.component.css']
})
export class UpdatedocComponent implements OnInit {
  doctorid!: number;
  doctors : Doctor = new Doctor();

  constructor(private docservice:DoctorService, private routes:Router,private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.doctors=new Doctor();
    this.doctorid = this.route.snapshot.params['doctorid'];
    this.docservice.viewdoctorbyid(this.doctorid).subscribe(data =>{
      this.doctors = data;
    }, error => console.log(error));
  }

  updatedoc(){
    this.docservice.modifydoctor(this.doctorid,this.doctors).subscribe(data =>{
      
    }, error => console.log(error));
    alert("***** Doctor details Updated *****")
    this.doctors = new Doctor();
    this.gotoadmin();
    
  }

  gotoadmin(){
    this.routes.navigate(['adminpage'])
  }

}
