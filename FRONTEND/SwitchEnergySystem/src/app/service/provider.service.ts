import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { provider } from "../enroll-provider/provider";
import { user } from "../user-display/user";
import { smartMeter } from "../user-display/smartMeter";
import { userEnrollType } from "../user-display/user-enroll-type";

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
    ViewAllProviders():Observable<any> {
        return this.http.get(`${this.baseURL}viewproviders`)
    }
    updateProviders(smartmeterid:String,providerid:String,userName:String):Observable<any> {
        return this.http.put(`${this.userURL}smartmeterid/${smartmeterid}/providerid/${providerid}/userName/${userName}`,smartmeterid);
    }
    createSmartMeter(userName:String):Observable<any> {
        return this.http.post(`${this.userURL}userName/${userName}`,userName)
    }
    getUserCount(userName:String):Observable<Object> {
        return this.http.get(`${this.userURL}userName/${userName}`)
    }
    getUserWithSamrtMeters(userName:String):Observable<any> {
        return this.http.get(`${this.smartMeterURL}userName/${userName}`)
    }
    enrollSmartMeterForAUser(NewuserEnrollType:userEnrollType):Observable<Object> {
        return this.http.post(`${this.smartMeterURL}enroll`,NewuserEnrollType);
    }
    getUserWithSmartMetersPending(userName:String): Observable<any>{
        return this.http.get(`${this.smartMeterURL}pending/userName/${userName}`)
    }
    approveSmartMeter(approvalStatus:String,smartMeterId:String): Observable<any>{
        return this.http.put(`${this.smartMeterURL}approvalstatus/${approvalStatus}/smartmeterid/${smartMeterId}`,smartMeterId);
    }
    getCountOfSmartMeters(providerId:String|null) {
        return this.http.get(`${this.smartMeterURL}count/providerId/${providerId}`)
    }
    changeProviders(smartMeterId:String,providerId:String): Observable<any> {
        return this.http.put(`${this.smartMeterURL}update/smartMeterId/${smartMeterId}/providerIdToBeChanged/${providerId}`,smartMeterId);
    }
}