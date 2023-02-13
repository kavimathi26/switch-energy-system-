import { Component, OnInit } from '@angular/core';
import { provider } from './provider';
import { Provider } from '../service/provider.service';

@Component({
  selector: 'app-enroll-provider',
  templateUrl: './enroll-provider.component.html',
  styleUrls: ['./enroll-provider.component.css']
})
export class EnrollProviderComponent implements OnInit {
providerId:String="";
providerName:String="";
enrollProvider:Array<provider>=[];
enroll() {
  this.setProvider();
  console.log(this.enrollProvider);
  this.sendProvider();
}
  constructor(private service: Provider) {
    
   }

  ngOnInit(): void {
  }
setProvider() {
    this.enrollProvider.push({ "providerId": this.providerId, "providerName": this.providerName,"countOfSmartMeters":0,"amountChargedPerUnit":25.0,visibility:"enable" });
  }
sendProvider() {
  this.service.setProvider(this.enrollProvider[0]).subscribe((res) => {
    console.log(res);
    
  })
}
}
