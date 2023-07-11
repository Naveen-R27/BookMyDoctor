import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './components/signup/signup.component';
import { AdminComponent } from './components/admin/admin.component';
import { AdminpageComponent } from './components/adminpage/adminpage.component';
import { AdddoctorComponent } from './components/adddoctor/adddoctor.component';
import { UpdatedocComponent } from './components/updatedoc/updatedoc.component';
import { AddbookingComponent } from './components/addbooking/addbooking.component';
import { PatientpageComponent } from './components/patientpage/patientpage.component';
import { DeletedoctorComponent } from './components/deletedoctor/deletedoctor.component';
import { DoctorpageComponent } from './components/doctorpage/doctorpage.component';
import { DoctorappointComponent } from './components/doctorappoint/doctorappoint.component';
import { AuthGuard } from './auth.guard';
import { DeletepatientComponent } from './components/deletepatient/deletepatient.component';
import { LoginComponent } from './components/login/login.component';
import { DocloginComponent } from './components/doclogin/doclogin.component';
import { AddfeedbackComponent } from './components/addfeedback/addfeedback.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path:'signup',component:SignupComponent},
  {path:'admin',component:AdminComponent},
  {path:'adminpage',component:AdminpageComponent, canActivate: [AuthGuard] }, //canActivate:[AuthGuard]
  {path:'adddoc',component:AdddoctorComponent},
  {path:'updatedoc/:doctorid',component:UpdatedocComponent},
  {path:'addappoint/:doctorid',component:AddbookingComponent},
  {path:'patientpage',component:PatientpageComponent, canActivate: [AuthGuard]},
  {path:'deldoc/:doctorid',component:DeletedoctorComponent},
  {path :'doctorpage',component:DoctorpageComponent},
  {path: 'doctorappoint/:docid',component:DoctorappointComponent},
  {path: 'deletepat/:patientid',component:DeletepatientComponent},
  {path: 'login',component:LoginComponent},
  {path: 'doclogin',component:DocloginComponent},
  {path: 'feedback',component:AddfeedbackComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
