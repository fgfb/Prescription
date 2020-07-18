import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  autheticate(username: string, password: string){
    if(username == 'jathinganta@gmai.com' && password == 'jathin'){
      localStorage.setItem('username', username);
      return true;
    }
    else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = localStorage.getItem('username');
    return !(user === null);
  }

  logout(){
    localStorage.removeItem('username');
  }
}
