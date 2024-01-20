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

  public finduserbyemail(user: any): Observable<any> {
    var email = user.email;
    console.log(user.email);
    var result: Observable<any> = this.http.get<any>(
      `${this.apiServerUrl}/User/detail/${email}`
    );
    console.log('this is result' + result);
    return result;
  }
}
