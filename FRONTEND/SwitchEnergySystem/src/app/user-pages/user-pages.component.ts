import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-pages',
  templateUrl: './user-pages.component.html',
  styleUrls: ['./user-pages.component.css']
})
export class UserPagesComponent implements OnInit {
user=sessionStorage.getItem('name');
  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  viewSmartMeterReadings() {
    this.router.navigateByUrl('user/view');
  }
  viewProvidersCurrentRates() {
    this.router.navigateByUrl('user/provider/view');  
  }
}
