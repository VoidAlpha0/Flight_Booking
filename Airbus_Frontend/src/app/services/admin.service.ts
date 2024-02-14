import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ErrorHandler, Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';

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
  addLocation(location: Partial<{ terminal: null; city: null; state: null; }>): Observable<Object>{
    return this.http
    .post(
      `${this.baseUrl}/addLoc`,
      JSON.stringify(location),
        this.options
    )
  }
  public getLocations(){
    let location= this.http.get('http://localhost:8086/Admin/getLocations')
    console.log(location)
    return this.http.get('http://localhost:8086/Admin/getLocations')
  }




  addFlight(flight: any, dropdownChoiceValue: never): Observable<Object> {
    console.log(flight);
    return this.http.post(`${this.baseUrl}/addFlight/${dropdownChoiceValue}/5`, JSON.stringify(flight),this.options);
  }
}
