import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private http: HttpClient) {}

  private baseUrl = "http://localhost:8086/Admin";
  httpHeaders = new HttpHeaders({
    "Content-Type": "application/json",
  });
  options = { headers: this.httpHeaders };

  adminLogin(admin: any): Observable<any> {
    console.log(JSON.stringify(admin));
    return this.http
      .post(
        `${this.baseUrl}/adminLogin`,
        JSON.stringify(admin),
        this.options
      )
  }

}
