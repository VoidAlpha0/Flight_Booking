import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { UserServiceService} from 'src/app/services/user-service.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit{
public userId: any;
public user: any;

constructor(private router: Router, private route: ActivatedRoute, private appService: UserServiceService) {}

ngOnInit(): void {
  let userId = localStorage.getItem("userId");
  this.userId = userId;
  this.getUser(userId);
}

logout() {
  this.router.navigate(['/user-login']);
}

gotoBookflight(){
  localStorage.setItem("userId",this.userId);
  this.router.navigate(['/user-viewFlights']);
}

gotoUpdate(){
  this.router.navigate(['user-update']);
}

gotoAddPassenger(){
  this.router.navigate(['/user-addPassenger'],this.userId);
}


public getUser(eid: any): void {
  this.appService.finduserbyID(this.userId).subscribe(
    (response: any) => {
      this.user = response;
      console.log(response);
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}


}
