import { Component , OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { UserServiceService} from 'src/app/services/user-service.service';
declare var $: any;

@Component({
  selector: 'app-show-tickets',
  templateUrl: './user-home-show-tickets.component.html',
  styleUrls: ['./user-home-show-tickets.component.css']
})

export class UserHomeShowTicketsComponent {
  public userId: any;
  public passId: any;
  tickets:any=[];
  tickt:any;
  flight:any;
  passenger:any;
  constructor(private router: Router, private route: ActivatedRoute, 
    private appService: UserServiceService, private formBuilder: FormBuilder) {}

    ngOnInit(): void {
      let userId = localStorage.getItem('userId');
      let passId = localStorage.getItem('passId');
      this.userId = userId;
      this.passId=passId;
      this.viewTickets(this.passId);
      this.getPassenger(this.passId);
    }



    public viewTickets(passid:any): void {
      this.appService.getTickets(passid).subscribe(
        (response: any) => {
          this.tickets = response;
          console.log(response);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

    public getflight(ticketId:any){
      this.appService.getTicketFlight(ticketId).subscribe(
        (response: any) => {
          this.flight = response;
          console.log(response);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

    public getPassenger(passId:any){
      this.appService.findPassenger(passId).subscribe(
        (response: any) => {
          this.passenger = response;
          console.log(response);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }


    gotoUserhome(){

    }

    openBoardingPassModal(ticket: any): void {
      // You can set the boarding pass information dynamically based on the selected ticket
      // For example, if your ticket object has a property called 'boardingPass', you can do:
      // this.boardingPass = ticket.boardingPass;
      this.tickt=ticket;
      let ticketId=ticket.ticketId;
      this.getflight(ticketId);
      // Open the modal
      $('#boardingPassModal').modal('show');
    }

    cancelTicket(ticket:any):void{
      const confirmation = window.confirm('Are you sure you want to cancel this ticket?');

    if (confirmation) {
        this.tickt = ticket;
        const ticketId = ticket.ticketId;
     
        this.appService.CancelTicket(ticketId).subscribe(
          (response: any) => {
            this.viewTickets(this.passId);
            console.log(response);
          },
          (error: HttpErrorResponse) => {
            alert(error.message);
          }
        );

        
    // Implement cancel ticket
    // Call your cancellation logic here
      } 
  
  else {
    // User clicked "Cancel" in the confirmation dialog
    // Do nothing or provide additional feedback to the user
  }
    
  }

}
