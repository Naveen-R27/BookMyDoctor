import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/models/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-deletedoctor',
  templateUrl: './deletedoctor.component.html',
  styleUrls: ['./deletedoctor.component.css']
})
export class DeletedoctorComponent implements OnInit {
  doctorid!:number;
  doctor : Doctor = new Doctor();

  constructor(private doctorservice:DoctorService,private routes:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
  this.doctor=new Doctor();
  this.doctorid = this.route.snapshot.params['doctorid'];
  this.doctorservice.removedoctor(this.doctorid).subscribe(data =>{
    this.routes.navigate(['adminpage']);
    //alert("Deleted successfully")
  }, error => console.log(error));

  }

}
