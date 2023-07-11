import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { AuthGuard } from 'src/app/auth.guard';



@Component({
  selector: 'admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  //providers:[AuthGuard]
})
export class AdminComponent implements OnInit {
  //showTable: boolean = false;

  constructor(private router :Router) { }

  ngOnInit(): void {
  }

  
  login(){
    //this.showTable = true;
    //console.log(this.showTable);
    
    this.router.navigate(['adminpage'],{skipLocationChange:true});
    

  }

 
}
