import { Component, OnInit } from '@angular/core';
import { Provider } from '../service/provider.service';
import { user } from './user';

@Component({
  selector: 'app-user-display',
  templateUrl: './user-display.component.html',
  styleUrls: ['./user-display.component.css']
})
export class UserDisplayComponent implements OnInit {
  // smartMeters:user[]=[];
smartMeters:Array<user>=[];
  userId="";
  smartMeterId ="";
  totalReadings="";
  amountToBePaid="";
  providerId="";
  constructor(private service: Provider) {
    this.service.viewOneUser("Arulsaru").subscribe((res) => {
      console.log(res);
      this.userId=res[0].userId;
      this.smartMeterId=res[0].smartMeterId;
      this.ViewReadingsAndAmountToBePaid();
      this.providerId=res[0].providerId;
      // this.smartMeters.push({"userId":this.userId,"smartMeterId":this.smartMeterId,"totalReadings":this.totalReadings,"amountToBePaid":this.amountToBePaid,"providerId":this.providerId});
      // console.log(this.userId);
      console.log(this.smartMeters);
    this.ViewReadingsAndAmountToBePaid();
      
      
    })
  }
  ViewReadingsAndAmountToBePaid() {
    this.service.ViewReadingsAndAmountToBePaid("Arulsaru", "63eb7e14cf20751556dd50bc").subscribe((res1 => {
      console.log(res1);
      this.totalReadings=res1[0].totalReadings;
      this.amountToBePaid=res1[0].amountToBePaid;
      // this.smartMeters=res;
      console.log(this.smartMeters);
      this.smartMeters.push({"userId":this.userId,"smartMeterId":this.smartMeterId,"totalReadings":this.totalReadings,"amountToBePaid":this.amountToBePaid,"providerId":this.providerId});

    }))
  }
  
  ngOnInit(): void {

  }

}
