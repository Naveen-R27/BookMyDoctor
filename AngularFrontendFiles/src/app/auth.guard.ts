import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
//import { AdminComponent } from './components/admin/admin.component';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private routes : Router){}

  //constructor(private auth:AdminComponent){

  //}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    //return this.auth.showTable;
    if(this.routes.url ==='/'){
      this.routes.navigate(['']);
      return false;

    }
    return true;
  }
  
}
