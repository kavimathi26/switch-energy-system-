import { Component, OnInit } from '@angular/core';
import { AuthRequestType } from './authRequest';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
userName:string='';
password:string='';
role:string='';
  constructor() {  }

  ngOnInit(): void {
  }

  // authRequest: AuthRequestType = {
  //   // "userName": "",
  //   // "password": "",
  //   // "role": ""
  // };
  authRequest:Array<AuthRequestType>=[];

  setAuthRequest(){
    // this.userName=userName;
    // this.password=password;
    // this.role=role;
    this.authRequest.push({"userName":this.userName,"password":this.password,"role":this.role});
    console.log(this.authRequest);
    
  }

}
