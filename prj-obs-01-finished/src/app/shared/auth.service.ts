import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {jwtDecode} from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isAuthenticated:boolean=false;
  roles:any;
  username:any;
  accessToken!:string;
  constructor(private http:HttpClient) { }

    public login(username:string,password:string){
      let options={
        headers:new HttpHeaders().set("Content-Type" ,"application/x-www-form-urlencoded")
      }
      let params=new HttpParams()
        .set("username",username)
        .set("password",password);
      return this.http.post("http://localhost:8081/auth/login",params,options);
    }

  loadProfile(data: any) {
    console.log("hellol");
    this.isAuthenticated=true;
    console.log("hellol"+data['access-token']);
    this.accessToken=data['access-tocken'];
    let jwtDecoder:any= jwtDecode(this.accessToken);
    this.username=jwtDecoder.sub;
    console.log(this.username);
    this.roles=jwtDecoder.scope;
  }

  logout() {
    this.isAuthenticated=false;
    this.accessToken=undefined;
    this.username=undefined;
    this.roles=undefined;
  }
}
