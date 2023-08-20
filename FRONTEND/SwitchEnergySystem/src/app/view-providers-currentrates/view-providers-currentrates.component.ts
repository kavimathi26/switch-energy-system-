import { Component, OnInit } from '@angular/core';
import { provider } from '../enroll-provider/provider';
import { Provider } from '../service/provider.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-providers-currentrates',
  templateUrl: './view-providers-currentrates.component.html',
  styleUrls: ['./view-providers-currentrates.component.css']
})

export class ViewProvidersCurrentratesComponent implements OnInit {
  
  providerArray: Array<provider> = [];

  constructor(private router: Router,private service: Provider) { }

  ngOnInit(): void {
    this.service.ViewAllProviders().subscribe((res) => {
      console.log(res);
      this.providerArray = res;
    })
  }

  goBackForUser() {
    this.router.navigateByUrl('user/page');
  }
}