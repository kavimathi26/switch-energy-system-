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
  providers: Array<provider> = [];
  visibility: String = "";
  count: number = 0;
  limit: number = 0;
  page: number = 0;


  datas: Array<any> = [];
  smartMeters: Array<any> = [];

  constructor(private router: Router, private service: Provider) {
    this.service.viewProviderForAdmin().subscribe(response => {
      this.providers = response;
      this.count = 100;
    }
    )
  }
  
  editVisibility(visibility: String | null, providerId: String | null) {

    if (visibility == "Enable") {
      this.visibility = "Disable";
    }

    if (visibility == "Disable") {
      this.visibility = "Enable";
    }

    this.datas.push()
    this.service.updateVisibility(this.visibility, providerId).subscribe(response => {
      console.log(response);
    })
    window.location.reload();
  }

  viewSmartMeters(providerId: String | null) {
    this.service.viewSmartMeters(providerId).subscribe(respronse => {
      this.smartMeters = respronse;
    })
  }

  getCountOfSmartMeters(providerId: String | null) {
    this.service.getCountOfSmartMeters(providerId).subscribe(Response => {
      console.log(Response);
    })
  }

  backToMainPage() {
    const tempRouter = this.router;
    tempRouter.navigate(['providers/view']);
  }

  goBack() {
    this.router.navigateByUrl('admin/page');
  }
  ngOnInit(): void {  }

  p: number = 1;
  items: number = 10;

}