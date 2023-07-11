import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './components/signup/signup.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './components/admin/admin.component';
import { AdminpageComponent } from './components/adminpage/adminpage.component';
import { AdddoctorComponent } from './components/adddoctor/adddoctor.component';
import { UpdatedocComponent } from './components/updatedoc/updatedoc.component';
import { AddbookingComponent } from './components/addbooking/addbooking.component';
import { PatientpageComponent } from './components/patientpage/patientpage.component';
import { DeletedoctorComponent } from './components/deletedoctor/deletedoctor.component';
import { DoctorpageComponent } from './components/doctorpage/doctorpage.component';
import { DoctorappointComponent } from './components/doctorappoint/doctorappoint.component';
import { FilterPipe } from './Pipes/filter.pipe';
import { AuthGuard } from './auth.guard';
import { DeletepatientComponent } from './components/deletepatient/deletepatient.component';
import { LoginComponent } from './components/login/login.component';
import { DocloginComponent } from './components/doclogin/doclogin.component';
import { AddfeedbackComponent } from './components/addfeedback/addfeedback.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignupComponent,
    AdminComponent,
    AdminpageComponent,
    AdddoctorComponent,
    UpdatedocComponent,
    AddbookingComponent,
    PatientpageComponent,
    DeletedoctorComponent,
    DoctorpageComponent,
    DoctorappointComponent,
    FilterPipe,
    DeletepatientComponent,
    LoginComponent,
    DocloginComponent,
    AddfeedbackComponent,
   
   
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthGuard], //AuthGuard
  bootstrap: [AppComponent]
})
export class AppModule { }
