import { Component, OnInit } from '@angular/core';
import { Provider } from '../service/provider.service';
import { user } from './user';

@Component({
  selector: 'app-user-display',
  templateUrl: './user-display.component.html',
  styleUrls: ['./user-display.component.css']
})
export class UserDisplayComponent implements OnInit {
  smartMeters:user[]=[];
  s =[];
  constructor(private service: Provider) { 
    this.service.viewOneUser("User101").subscribe((res) => {
      this.smartMeters = res;
      console.log(this.smartMeters);
    })
    this.ViewReadingsAndAmountToBePaid();
  }
  ViewReadingsAndAmountToBePaid(){
  this.service.ViewReadingsAndAmountToBePaid("User101","63ea6491f0a49d592f59a7ab").subscribe((res=> {
    console.log(res);
    // this.smartMeters=res;
    // console.log(this.smartMeters);
    
  }))
  }
  ngOnInit(): void {  }

}
