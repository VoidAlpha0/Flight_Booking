import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private apiServerUrl = environment.apiBaseUrl;
 
  console: any;
  
  result: any;
  constructor(private http: HttpClient) { }

  public finduserbyemail(useremail: any): Observable<any> {
    //var email = user.email;
    console.log(useremail);
    var result: Observable<any> = this.http.get<any>(
      `${this.apiServerUrl}/User/detail/${useremail}`
    );
    console.log('this is result' + result);
    return result;
  }

  public finduserbyID(userId: any): Observable<any> {
    //var email = user.email;
    console.log(userId);
    var result: Observable<any> = this.http.get<any>(
      `${this.apiServerUrl}/User/details/${userId}`
    );
    console.log('this is result' + result);
    return result;
  }

  public updateUser(editbody:any,userId:any): Observable<any> {
    //var email = user.email;
    console.log(userId);
    var result: Observable<any> = this.http.put<any>(
      `${this.apiServerUrl}/User/update/${userId}`,
    editbody);
    console.log('this is result' + result);
    return result;
  }

  public findallFlights():Observable<any>{
    var result: Observable<any> = this.http.get<any>(
      `${this.apiServerUrl}/User/viewFlights`
    );
    console.log('this is result' + result);
    return result;
  }

  public createPassenger(passengerbody:any, userId:any): Observable<any> {
    //var email = user.email;
    console.log(userId);
    var result: Observable<any> = this.http.post<any>(
      `${this.apiServerUrl}/User/createPass/${userId}`,
    passengerbody);
    console.log('this is result' + result);
    return result;
  }

  public findPassengers(userId:any): Observable<any> {
    //var email = user.email;
    console.log(userId);
    var result: Observable<any> = this.http.get<any>(
      `${this.apiServerUrl}/User/getPass/${userId}`);
    console.log('this is result' + result);
    return result;
  }


  public getbookedSeats(flightId:any): Observable<any> {
   console.log(flightId);
    var result: Observable<any> = this.http.get<any>(
      `${this.apiServerUrl}/Booking/getTickets/${flightId}`);
    console.log('this is result' + result);
    return result;
  }

  public bookTickets(combinedData:any,flightId:any):Observable<any> {
    console.log(combinedData);
     var result: Observable<any> = this.http.post<any>(
       `${this.apiServerUrl}/Booking/ticketgen/${flightId}`, combinedData);
     console.log('this is result' + result);
     return result;
   }
 
}
