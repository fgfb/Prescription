import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PrescriptionService {

  constructor(private http: HttpClient) { }

  url = "http://localhost:9090/api/v1/medik/form";

  submitPrescription(doctorEmailId:string, form:any): Observable<any>{
    return this.http.post(this.url+"/"+doctorEmailId, form);
  }

}
