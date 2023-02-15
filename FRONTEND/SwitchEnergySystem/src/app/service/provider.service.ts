import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { provider } from "../enroll-provider/provider";
import { user } from "../user-display/user";
import { smartMeter } from "../user-display/smartMeter";

@Injectable({
    providedIn: 'root'
})

export class Provider {
    
    baseURL: string = 'http://localhost:8080/provider/';
    smartMeterURL: string='http://localhost:8080/smartmeter/';
    userURL: string='http://localhost:8080/user/';
    userDetails: user[] = [];
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
    viewSmartMeters(providerId:String|null):Observable<any> {
        return this.http.get(`${this.smartMeterURL}providerId/${providerId}`)
    }
    viewOneUser(userId:string):Observable<user[]>{
        return this.http.get<user[]>(`${this.userURL}viewoneuser/userId/${userId}`)
    }
    ViewReadingsAndAmountToBePaid(userId:string|null,smartMeterId:String|null):Observable<user[]> {
        return this.http.get<user[]>(`${this.userURL}view/userId/${userId}/smartMeterId/${smartMeterId}`)
    }
    ViewAllProviders():Observable<any> {
        return this.http.get(`${this.baseURL}viewproviders`)
    }
    updateProviders(smartmeterid:String,providerid:String,userId:String):Observable<any> {
        return this.http.put(`${this.userURL}smartmeterid/${smartmeterid}/providerid/${providerid}/userId/${userId}`,smartmeterid);
    }
    createSmartMeter(userId:String):Observable<any> {
        return this.http.post(`${this.userURL}userId/${userId}`,userId)
    }
    getUserCount(userId:String):Observable<Object> {
        return this.http.get(`${this.userURL}userId/${userId}`)
    }
}