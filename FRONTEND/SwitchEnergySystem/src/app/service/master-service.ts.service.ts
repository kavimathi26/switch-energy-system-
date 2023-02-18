import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MasterServiceTsService {

  constructor(private http:HttpClient) { }
  GetProviders() {
    return this.http.get('https://localhost:8080/provider/viewproviders');
  }
}
