import { Component, OnInit } from '@angular/core';
import { Provider } from '../service/provider.service';

@Component({
  selector: 'app-view-smartmeter-list',
  templateUrl: './view-smartmeter-list.component.html',
  styleUrls: ['./view-smartmeter-list.component.css']
})
export class ViewSmartmeterListComponent implements OnInit {
smartMeters:Array<any> = [];
  constructor(private service:Provider) { }

  ngOnInit(): void {
  }
  viewSmartMeters(providerId: String | null) {
    this.service.viewSmartMeters(providerId).subscribe(respronse => {
      console.log(respronse);
      this.smartMeters=respronse;
      console.log(this.smartMeters);
      
    })
  }
}
