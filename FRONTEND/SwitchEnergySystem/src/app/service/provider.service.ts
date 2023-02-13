import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { provider } from "../enroll-provider/provider";

@Injectable({
    providedIn: 'root'
})

export class Provider {
    
    baseURL: string = 'http://localhost:8080/provider/';
    constructor(private http: HttpClient) {} 

    setProvider(newProvider: provider): Observable<provider> {
        return this.http.post<provider>(`${this.baseURL}enroll`,newProvider);
    }
    viewProvider():Observable<any>{
        return this.http.get(`${this.baseURL}topproviders/page/0/limit/100`)
    }
    updateVisibility(visibility:String|null,providerId:String|null):Observable<any> {
        return this.http.put(`${this.baseURL}visibility/${visibility}/providerid/${providerId}`,visibility);
      }
}