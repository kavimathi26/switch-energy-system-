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
  resRole: String = '';

  constructor(private router: Router, private service: Provider) { }

  ngOnInit(): void { }

  authRequest: Array<AuthRequestType> = [];

  setAuthRequest() {
    this.authRequest.push({ "userName": this.userName, "password": this.password });
    sessionStorage.setItem("name", this.userName);
    this.getAccessToken();
    this.getUserType();
  }

  public getAccessToken() {
    this.service.generateToken(this.authRequest[this.authRequest.length - 1]).subscribe(data =>
      sessionStorage.setItem("token", data.token)
    );
  }

  routeToAdmin() {
    if (this.resRole == "USER") {
      this.router.navigateByUrl('user/page');
    }
    else if (this.resRole == "ADMIN") {
      this.router.navigateByUrl('admin/page');
    }
  }

  getUserType() {
    this.service.getRole(this.userName).subscribe((res) => {
      this.resRole = res;
      this.routeToAdmin();
    })
  }

}
