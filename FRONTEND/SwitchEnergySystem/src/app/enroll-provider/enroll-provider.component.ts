import { Component, OnInit } from '@angular/core';
import { provider } from './provider';
import { Provider } from '../service/provider.service';
import { TokenInterceptorServiceTsService } from '../service/token-interceptor-service.ts.service';

@Component({
  selector: 'app-enroll-provider',
  templateUrl: './enroll-provider.component.html',
  styleUrls: ['./enroll-provider.component.css']
})
export class EnrollProviderComponent implements OnInit {
providerId:String="";
providerName:String="";
amountCharged:Number=0;
enrollProvider:Array<provider>=[];
enroll() {
  this.setProvider();
  console.log(this.enrollProvider);
  this.sendProvider();
}
  constructor(private service: Provider,private service1:TokenInterceptorServiceTsService) {
    
   }

  ngOnInit(): void {
    this.getAccessToken(this.authRequest);
  }

  authRequest:any={
    "userName":"Kavi123",
    "password":"kavimathi",
    "role":"USER"
  };

  response:any;

  public getAccessToken(authRequest: any){
    let resp=this.service.generateToken(authRequest);
    resp.subscribe(data=>this.accessApi(data));
      }
    
    
      public accessApi(token: string){
    let resp=this.service.welcome(token);
    console.log(resp);
    
    resp.subscribe(data=>this.response=data);
      }



setProvider() {
    this.enrollProvider.push({ "providerId": this.providerId, "providerName": this.providerName,"countOfSmartMeters":0,"amountChargedPerUnit":this.amountCharged,visibility:"Enable" });
  }
sendProvider() {
  this.service.setProvider(this.enrollProvider[0]).subscribe((res) => {
    console.log(res);
    
  })
}
}
