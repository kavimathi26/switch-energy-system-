import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EnrollProviderComponent} from './enroll-provider/enroll-provider.component';
import { ViewEnableDisableProviderComponent } from './view-enable-disable-provider/view-enable-disable-provider.component';
const routes: Routes = [{ path: 'providers/create', component: EnrollProviderComponent },
{ path: 'providers/view', component: ViewEnableDisableProviderComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
