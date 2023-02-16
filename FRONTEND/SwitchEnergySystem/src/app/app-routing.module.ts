import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcceptRejectSmartmeterComponent } from './accept-reject-smartmeter/accept-reject-smartmeter.component';
import { EnrollProviderComponent } from './enroll-provider/enroll-provider.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { UserDisplayComponent } from './user-display/user-display.component';
import { ViewEnableDisableProviderComponent } from './view-enable-disable-provider/view-enable-disable-provider.component';
import { ViewProvidersCurrentratesComponent } from './view-providers-currentrates/view-providers-currentrates.component';
import { ViewSmartmeterListComponent } from './view-smartmeter-list/view-smartmeter-list.component';
const routes: Routes = [{ path: 'providers/create', component: EnrollProviderComponent },
{ path: 'providers/view', component: ViewEnableDisableProviderComponent },
{ path: 'user/view', component: UserDisplayComponent },
{ path: 'approval-status/smartmeters', component: AcceptRejectSmartmeterComponent },
{ path: 'view/smartmeters', component: ViewSmartmeterListComponent },
{ path: 'login', component: LoginComponentComponent },
{ path: 'user/provider/view', component: ViewProvidersCurrentratesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
