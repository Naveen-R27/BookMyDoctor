import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/models/doctor';
import { DoctorService } from 'src/app/services/doctor.service';
import { FeedbackService } from 'src/app/services/feedback.service';
import { Feedback } from 'src/app/models/feedback';

@Component({
  selector: 'app-patientpage',
  templateUrl: './patientpage.component.html',
  styleUrls: ['./patientpage.component.css']
})
export class PatientpageComponent implements OnInit {
  filteredString: string = '';

  showTable: boolean = false;
  //showtable1 :boolean = false;
  doctors : Doctor[] | undefined;
  feedback : Feedback[] | undefined;

  constructor(private routes:Router,private doctorservice:DoctorService,private feedbackservice :FeedbackService) { }

  ngOnInit(): void {
    this.getdoctors();
  }

  private getdoctors(){
    this.doctorservice.viewAlldoctor().subscribe(data => {
      this.doctors = data
    })
  }

  toggleShowTable(): void {
    this.showTable = !this.showTable;
}

appointdoc(doctorId:number){
  this.routes.navigate(['addappoint',doctorId],{skipLocationChange:true});
}

  //doctorid : string;
  //onSubmit(doc : string){
    //return this.doctorid;
    //alert(doc);
    //console.log(doc);
  //}


}
