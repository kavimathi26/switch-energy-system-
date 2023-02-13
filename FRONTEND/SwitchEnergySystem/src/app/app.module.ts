import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EnrollProviderComponent } from './enroll-provider/enroll-provider.component';
import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations' ;
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import { ViewEnableDisableProviderComponent } from './view-enable-disable-provider/view-enable-disable-provider.component';
import { AcceptRejectSmartmeterComponent } from './accept-reject-smartmeter/accept-reject-smartmeter.component';
@NgModule({
  declarations: [
    AppComponent,
    EnrollProviderComponent,
    ViewEnableDisableProviderComponent,
    AcceptRejectSmartmeterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
