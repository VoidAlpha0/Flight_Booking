import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { UserServiceService} from 'src/app/services/user-service.service';

@Component({
  selector: 'app-user-home-view-flights',
  templateUrl: './user-home-view-flights.component.html',
  styleUrls: ['./user-home-view-flights.component.css']
})
export class UserHomeViewFlightsComponent {
  public userId: any;
  flights:any=[];

  constructor(private router: Router, private route: ActivatedRoute, private appService: UserServiceService) {}

  ngOnInit(): void {
    let userId = localStorage.getItem('userId');
    this.userId = userId;
    this.viewFlights();
  }

  gotoSeats(){


  }

  gotoUserhome(){


  }


  public viewFlights(): void {
    this.appService.findallFlights().subscribe(
      (response: any) => {
        this.flights = response;
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
