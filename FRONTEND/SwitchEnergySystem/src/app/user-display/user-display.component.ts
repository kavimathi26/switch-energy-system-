import { Component, OnInit } from '@angular/core';
import { Provider } from '../service/provider.service';
import { responseSmartMeter } from './responeSmartMeter';
import { userEnrollType } from './user-enroll-type';

@Component({
  selector: 'app-user-display',
  templateUrl: './user-display.component.html',
  styleUrls: ['./user-display.component.css']
})
export class UserDisplayComponent implements OnInit {
  smartMeters: Array<any> = [];
  resSmartMeters: Array<responseSmartMeter> = [];
  userId = "Kavi123";
  smartMeterId = "";
  totalReadings: number = 0;
  amountToBePaid = "";
  providerId = "";
  userEnroll: Array<userEnrollType> = [{
    "userId": this.userId, "providerId": "DrEvil101",
    "approvalStatus": "Pending",
    "totalReadings": 0.0,
    "amountToBePaid": 0.0
  }];
  constructor(private service: Provider) {
    this.getUserWithSamrtMeters("Kavi123");
  }

  ngOnInit(): void { }


  viewAllProviders() {
    this.service.ViewAllProviders().subscribe((res) => {
    })
  }
  getUserWithSamrtMeters(userId: String) {
    this.service.getUserWithSamrtMeters(userId).subscribe((res) => {
      this.smartMeters = res;

    })
  }
  enrollSmartMeterForAUser() {
    this.service.enrollSmartMeterForAUser(this.userEnroll[0]).subscribe((res)=> {
      console.log(res);
      
    })
    window.location.reload();
  }
  createSmartMeter() {
    this.viewAllProviders();
    this.enrollSmartMeterForAUser();
  }


}
