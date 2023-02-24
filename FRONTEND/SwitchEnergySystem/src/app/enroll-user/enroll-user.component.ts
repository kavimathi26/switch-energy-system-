import { Component, OnInit } from '@angular/core';
import { Provider } from '../service/provider.service';
import { userEnrollTypeForSignup } from './userEnroll';

@Component({
  selector: 'app-enroll-user',
  templateUrl: './enroll-user.component.html',
  styleUrls: ['./enroll-user.component.css']
})

export class EnrollUserComponent implements OnInit {

  userName: string = '';
  password: string = '';
  role: string = '';
  signupRequest: Array<userEnrollTypeForSignup> = [];

  constructor(private service: Provider) { }

  ngOnInit(): void { }

  setSignupRequest() {
    this.signupRequest.push({ "userName": this.userName, "password": this.password, "role": this.role });
    this.service.userSignUP(this.signupRequest[this.signupRequest.length - 1]).subscribe((res) => { console.log(res); }
    )
  }

}
