import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuardService } from './services/auth-guard.service';
import { PrescriptionComponent } from './prescription/prescription.component';


const routes: Routes = [

  {path: "", redirectTo: "login", pathMatch: "full"},
  {path: "login", component: LoginComponent},
  {path: "logout", component: LogoutComponent, canActivate: [AuthGuardService]},
  {path: "home", component: HomeComponent, canActivate: [AuthGuardService]},
  {path: "prescription", component: PrescriptionComponent, canActivate: [AuthGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
