import { Component, OnInit } from '@angular/core';
import { Feedback } from 'src/app/models/feedback';
import { FeedbackService } from 'src/app/services/feedback.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addfeedback',
  templateUrl: './addfeedback.component.html',
  styleUrls: ['./addfeedback.component.css']
})
export class AddfeedbackComponent implements OnInit {
  feedback :Feedback =new Feedback();

  constructor(private feedbackservice:FeedbackService,private routes:Router) { }

  ngOnInit(): void {
  }

  addfeedback(){
    this.feedbackservice.addfeedback(this.feedback).subscribe(data =>{
      alert("FeedBack Submitted Successfully")
      this.routes.navigate(['patientpage'])
    },error=>alert("Sorry user not registered"));
  }

}
