import { Injectable } from '@angular/core';
import {Router} from '@angular/router';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {GestionService} from './gestion.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedIn: boolean=false;


  constructor(private router:Router,private gest:GestionService, private http: HttpClient) { }

  verifUser(username:string,password:string):Observable<any>{
    return this.http.get('http://localhost:11000/api/verif/'+username+"/"+password);
  }

  getCurrentUser(){
    let user= localStorage.getItem("currentUser")
    if(user){
      return JSON.parse(user);
    }else{
      return null;
    }
  }
  isConnected(): boolean {
    let user= localStorage.getItem("currentUser")
    if(user){
      return true;
    }else {
      return false;
    }
  }
  logout(){
    localStorage.removeItem("currentUser");
    this.loggedIn = false;
    this.router.navigateByUrl('/login');
  }
}
