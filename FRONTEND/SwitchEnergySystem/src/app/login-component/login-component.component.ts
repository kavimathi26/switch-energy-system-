import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Provider } from '../service/provider.service';
import { AuthRequestType } from './authRequest';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
  userName: string = '';
  password: string = '';
  role: string = '';
  resRole:String='';
  constructor(private router: Router, private service: Provider) { }

  ngOnInit(): void {
  }

  authRequest: Array<AuthRequestType> = [];

  setAuthRequest() {
    this.authRequest.push({ "userName": this.userName, "password": this.password, "role": "USER" });
    console.log(this.authRequest);
    this.getAccessToken();
    this.getUserType();    
  }

  public getAccessToken() {
    this.service.generateToken(this.authRequest[0]).subscribe(data =>
      sessionStorage.setItem("token", data.token)
    );
    this.routeToAdmin();
  }

  routeToAdmin() {
    if(this.role=="USER") {
      this.router.navigateByUrl('user/view');
    }
  }

  getUserType() {
    this.service.getRole(this.userName).subscribe((res)=>
    {
      this.resRole = res;
      
    }
    )
  }
}
