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

  public findallFlights():Observable<any>{
    var result: Observable<any> = this.http.get<any>(
      `${this.apiServerUrl}/User/viewFlights`
    );
    console.log('this is result' + result);
    return result;
  }


}
