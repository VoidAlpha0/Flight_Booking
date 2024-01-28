import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { UserServiceService} from 'src/app/services/user-service.service';

@Component({
  selector: 'app-user-viewPass',
  templateUrl: './user-home-view-pass.component.html',
  styleUrls: ['./user-home-view-pass.component.css']
})
export class UserHomeViewPassComponent {
  public userId: any;
  passengers:any=[];

  constructor(private router: Router, private route: ActivatedRoute, private appService: UserServiceService) {}

  ngOnInit(): void {
    let userId = localStorage.getItem('userId');
    this.userId = userId;
    this.viewPassengers(this.userId);
  }


  deletePassenger(){

    
  }

  public viewPassengers(userid:any): void {
    this.appService.findPassengers(userid).subscribe(
      (response: any) => {
        this.passengers = response;
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
