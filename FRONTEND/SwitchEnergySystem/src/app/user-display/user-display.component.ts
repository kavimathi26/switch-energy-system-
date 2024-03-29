import { Component, OnInit } from '@angular/core';
import { Provider } from '../service/provider.service';
import { responseSmartMeter } from './responeSmartMeter';
import { userEnrollType } from './user-enroll-type';
import Swal from 'sweetalert2'
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-display',
  templateUrl: './user-display.component.html',
  styleUrls: ['./user-display.component.css']
})

export class UserDisplayComponent implements OnInit {

  smartMeters: Array<any> = [];
  resSmartMeters: Array<responseSmartMeter> = [];
  providersArray: Array<any> = [];

  userName: string | null;
  smartMeterId = "";
  totalReadings: number = 0;
  amountToBePaid = "";
  providerId = "";

  userEnroll: Array<userEnrollType> = [{
    "userName": sessionStorage.getItem('name'), "providerId": "DrEvil101",
    "approvalStatus": "Pending",
    "totalReadings": 0.0,
    "amountToBePaid": 0.0
  }];

  constructor(private router: Router,private service: Provider) {
    this.userName = this.userName = sessionStorage.getItem('name');
    this.getUserWithSamrtMeters(this.userName);
  }

  ngOnInit(): void {
    this.viewAllProviders()
  }

  switchProviders(smartMeterId: String, providerId: String) {

    this.service.changeProviders(smartMeterId, providerId).subscribe((res) => {
      console.log(res);
      window.location.reload();
    })
  }

  viewAllProviders() {
    this.service.ViewAllProviders().subscribe((res) => {
      console.log(res);
      this.providersArray = res;
    })
  }

  getUserWithSamrtMeters(userName: string | null) {
    this.service.getUserWithSamrtMeters(userName).subscribe((res) => {
      this.smartMeters = res;
    })
  }

  enrollSmartMeterForAUser() {
    this.service.enrollSmartMeterForAUser(this.userEnroll[0]).subscribe((res) => {
      console.log(res);

    })
  }
  
  createSmartMeter() {
    Swal.fire({
      title: 'Your request will process soon!',
      showClass: {
        popup: 'animate__animated animate__fadeInDown'
      },
      hideClass: {
        popup: 'animate__animated animate__fadeOutUp'
      }
    })
    this.viewAllProviders();
    this.enrollSmartMeterForAUser();
  }

  goBackForUser() {
    this.router.navigateByUrl('user/page');
  }
}
