import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inValidLogin = false;
  username: '';
  password: '';

  constructor(
    private router: Router,
    private authService: AuthService) { }

  ngOnInit() {}

  checkLogin(){
    if(this.authService.autheticate(this.username, this.password)){
      this.router.navigate(['home']);
      this.inValidLogin = false;
    }
    else{
      this.inValidLogin = true;
    }
  }

}
