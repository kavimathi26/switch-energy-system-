import { Component, Input, OnInit } from '@angular/core';
import { Provider } from '../service/provider.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-smartmeter-list',
  templateUrl: './view-smartmeter-list.component.html',
  styleUrls: ['./view-smartmeter-list.component.css']
})

export class ViewSmartmeterListComponent implements OnInit {

  smartMeters: Array<any> = [];

  constructor(private router:Router,private service: Provider) { }
  ngOnInit(): void {  }

  viewSmartMeters(providerId: String | null) {
    this.service.viewSmartMeters(providerId).subscribe(respronse => {
      this.smartMeters = respronse;
    })
  }
  
}
