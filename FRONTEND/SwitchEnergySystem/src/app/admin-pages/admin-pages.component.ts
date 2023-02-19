import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-pages',
  templateUrl: './admin-pages.component.html',
  styleUrls: ['./admin-pages.component.css']
})
export class AdminPagesComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  viewProvidersPage() {
    this.router.navigateByUrl('providers/view');
  }
  approveSmartMetersPage() {
    this.router.navigateByUrl('approval-status/smartmeters');  
  }
  enrollProvidersPage() {
    this.router.navigateByUrl('providers/create');  
  }
  enrollUserPage() {
    this.router.navigateByUrl('user/enroll');
  }
}
