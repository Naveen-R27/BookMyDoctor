import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/models/patient';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-deletepatient',
  templateUrl: './deletepatient.component.html',
  styleUrls: ['./deletepatient.component.css']
})
export class DeletepatientComponent implements OnInit {

  patientid!:number;

  patient : Patient = new Patient();

  constructor(private routes:Router,private patientservice:PatientService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.patient=new Patient();
   this.patientid = this.route.snapshot.params['patientid'];
   this.patientservice.deleteUser(this.patientid).subscribe(data =>{
    this.routes.navigate(['adminpage']);
    //alert("Deleted successfully")
  }, error => console.log(error));
  }

}
