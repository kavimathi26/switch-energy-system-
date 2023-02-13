import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { provider } from '../enroll-provider/provider';
import { Provider } from '../service/provider.service';

@Component({
  selector: 'app-view-enable-disable-provider',
  templateUrl: './view-enable-disable-provider.component.html',
  styleUrls: ['./view-enable-disable-provider.component.css']
})
export class ViewEnableDisableProviderComponent implements OnInit {
providers: Array<provider>=[];
visibility: String = "";
count: number = 0;
limit: number = 0;
page: number = 0;
  constructor(private router: Router, private service:Provider) { 
    this.service.viewProvider().subscribe(response => {
      this.providers = response;
      this.count = 100;
    }
    )
  }
  datas: Array<any> = [];
  editVisibility(visibility:String|null,providerId:String|null){
    if(visibility=="enable")
    {
      this.visibility="disable";
    }
    if(visibility=="disable")
    {
      this.visibility="enable";
    }
    this.datas.push()
    this.service.updateVisibility(this.visibility,providerId).subscribe(response => {
      console.log(response);
    })
    // this.backToMainPage();
    window.location.reload();
  }
  backToMainPage() {
    const tempRouter = this.router;
    tempRouter.navigate(['providers/view']);
  }
  ngOnInit(): void {
  }
  p: number = 1;
  items: number = 10;
}
