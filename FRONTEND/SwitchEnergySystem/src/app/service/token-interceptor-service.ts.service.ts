import { HttpClient, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from "@angular/common/http";

import { Injectable } from '@angular/core';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorServiceTsService {

  constructor(private httpClient: HttpClient) { }
  public generateToken(request: any) {
    return this.httpClient.post<string>("http://localhost:8080/login/authenticate", request, {  responseType: 'text' as 'json' });
  }


  public welcome(token: string) {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.httpClient.get<string>("http://localhost:8080/provider/viewproviders", {headers, responseType: 'text' as 'json' });
  }
}
