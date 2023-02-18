import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { provider } from "../enroll-provider/provider";
@Injectable()

export class AdminService {
    constructor(private http: HttpClient) { }

    baseURL: string = 'http://localhost:8080/provider/';
    smartMeterURL: string = 'http://localhost:8080/smartmeter/';


    setProvider(newProvider: provider): Observable<provider> {
        return this.http.post<provider>(`${this.baseURL}enroll`, newProvider);
    }

    viewProvider(): Observable<any> {
        return this.http.get(`${this.baseURL}topproviders/page/0/limit/100`
        )
    }

    updateVisibility(visibility: String | null, providerId: String | null): Observable<any> {
        return this.http.put(`${this.baseURL}visibility/${visibility}/providerid/${providerId}`, visibility);
    }

    viewSmartMeters(providerId: String | null): Observable<any> {
        return this.http.get(`${this.smartMeterURL}providerId/${providerId}`)
    }

    ViewAllProviders(): Observable<any> {
        return this.http.get(`${this.baseURL}viewproviders`)
    }

    getUserWithSmartMetersPending(userName: String): Observable<any> {
        return this.http.get(`${this.smartMeterURL}pending/userName/${userName}`)
    }

    approveSmartMeter(approvalStatus: String, smartMeterId: String): Observable<any> {
        return this.http.put(`${this.smartMeterURL}approvalstatus/${approvalStatus}/smartmeterid/${smartMeterId}`, smartMeterId);
    }

    getCountOfSmartMeters(providerId: String | null) {
        return this.http.get(`${this.smartMeterURL}count/providerId/${providerId}`)
    }

}