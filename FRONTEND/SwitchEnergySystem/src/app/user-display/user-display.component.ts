import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Provider } from '../service/provider.service';
import { responseSmartMeter } from './responeSmartMeter';
import { user } from './user';

@Component({
  selector: 'app-user-display',
  templateUrl: './user-display.component.html',
  styleUrls: ['./user-display.component.css']
})
export class UserDisplayComponent implements OnInit {
  // smartMeters:user[]=[];
  smartMeters: Array<user> = [];
  // final: Array<user> = [];
  resSmartMeters: Array<responseSmartMeter> = [];
  userId = "Kavi123";
  smartMeterId = "";
  totalReadings: number = 0;
  amountToBePaid = "";
  providerId = "";
  userCount = this.getUserCount();

  constructor(private service: Provider) {
  }
  getUserCount() {
    this.service.getUserCount("Kavi123").subscribe((res) => {
      console.log(res);
      console.log(typeof (res));

    })
  }
  i = 0;
  // ViewReadingsAndAmountToBePaid(userId: string, smartMeterId: String) {
    ViewReadingsAndAmountToBePaid() {

    for (let i = 0; i < this.resSmartMeters.length; i++) {
      this.service.ViewReadingsAndAmountToBePaid(this.resSmartMeters[i].userId, this.resSmartMeters[i].smartMeterId).subscribe((res1 => {

        this.totalReadings = res1[i].totalReadings;
        this.amountToBePaid = res1[i].amountToBePaid;
        this.smartMeters.push({ "userId": this.userId, "smartMeterId": this.smartMeterId, "totalReadings": this.totalReadings, "amountToBePaid": this.amountToBePaid, "providerId": this.providerId });


        // this.final.push(this.smartMeters[0]);
      }))
      // this.i += 1;
    }
    
  }

  viewOneUser() {
    this.service.viewOneUser("Kavi123").subscribe((res) => {
      while (this.i < res.length) {        
        console.log(res[this.i]);

        this.userId = res[this.i].userId;
        this.smartMeterId = res[this.i].smartMeterId;
        this.providerId = res[this.i].providerId;

          // this.ViewReadingsAndAmountToBePaid(res[this.i].userId, res[this.i].smartMeterId);

        if (this.i == res.length) {
          break;
        }
      }
    })


  }
  // viewOneUser() {
  //   this.service.viewOneUser("Kavi123").subscribe((res) => {
  //     console.log(res);
  //     this.resSmartMeters = res;
  //     console.log(this.resSmartMeters);

  //   })
  // }

  viewAllProviders() {
    this.service.ViewAllProviders().subscribe((res) => {
    })
  }

  createSmartMeter() {
    this.viewOneUser();
    this.ViewReadingsAndAmountToBePaid();
    this.viewAllProviders();
    // console.log(this.final);
    console.log(this.smartMeters);

    // this.service.createSmartMeter(this.userId).subscribe((res) => {
    // })

  }
  ngOnInit(): void {

  }

}
