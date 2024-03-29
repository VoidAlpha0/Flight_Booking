import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { UserServiceService} from 'src/app/services/user-service.service';


@Component({
  selector: 'app-user-book-seats',
  templateUrl: './book-seats.component.html',
  styleUrls: ['./book-seats.component.css']
})
export class BookSeatsComponent implements OnInit{
  rows = ['A', 'B', 'C', 'D', 'E'];
  cols = ['1', '2', '3', '4'];
  public userId: any;
  passengers:any=[];
  public flightId:any;
  selectedSeatsCount: number = 0;
selectedPassengersCount: number = 0;
seatsBooked:any=[];
  seats: any[] = [];
  selectedSeats: any[] = [];
  selectedPassengers: any[] = [];

  constructor(private router: Router, private route: ActivatedRoute, private appService: UserServiceService) {}
  
  ngOnInit(): void {
    let userId = localStorage.getItem('userId');
    let flightId=localStorage.getItem('flightId');
    this.userId = userId;
    this.flightId=flightId;
    console.log(this.flightId);
    this.viewPassengers(this.userId);
    //this.viewBooked(this.flightId);
    // Initialization - you may fetch seat data from the server
    // For simplicity, this example initializes some seats as booked
    this.appService.getbookedSeats(flightId).subscribe(
      (response: any) => {
        this.seatsBooked = response;
        console.table(this.seatsBooked);
        this.initializeSeats();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }

    );
    
  }

  generateSeatLayout(): any[][] {
    const seatLayout: any[][] = [];
  
    this.rows.forEach(row => {
      const rowSeats: any[] = [];
  
      this.cols.forEach(col => {
        const seat = this.getSeat(row, col);
        rowSeats.push(seat);
      });
  
      seatLayout.push(rowSeats);
    });
  
    return seatLayout;
  }

  updateSeatSelection(): void {
    this.seats.forEach(seat => {
      const correspondingSeat = this.getSeat(seat.seatNo[0], +seat.seatNo.slice(1));
      seat.isSelected = correspondingSeat.isSelected;
    });
  }



 

  selectSeat(seat: any): void {
    if (this.canSelectSeat(seat)) {
      seat.isSelected = !seat.isSelected;
      this.updateSeatSelection();
      this.selectedSeatsCount += seat.isSelected ? 1 : -1;
  
      // Store selected seat in the array
      if (seat.isSelected) {
        this.selectedSeats.push(seat.seatNo);
      } else {
        const index = this.selectedSeats.indexOf(seat.seatNo);
        if (index !== -1) {
          this.selectedSeats.splice(index, 1); // Remove from array when deselected
        }
      }
    }
    console.log(this.selectedSeats);
  }
  
  canSelectSeat(seat: any): boolean {
    return !seat.isBooked ;
  }

  canSelectPassenger(seat: any): boolean {
    if(this.selectedPassengersCount>0){
    return (this.selectedPassengersCount==this.selectedSeatsCount);}
    else return false;
  }
  selectPassenger(passenger: any): void {
    passenger.isSelected = !passenger.isSelected;
    this.selectedPassengersCount += passenger.isSelected ? 1 : -1;
  
    // Store selected passenger in the array
    if (passenger.isSelected) {
      this.selectedPassengers.push(passenger);
    } else {
      const index = this.selectedPassengers.indexOf(passenger);
      if (index !== -1) {
        this.selectedPassengers.splice(index, 1); // Remove from array when deselected
      }
    }
    console.log(this.selectedPassengers);
  }

  getSeat(row:any, col:any): any {
    return this.seats.find(seat => seat.seatNo === row + col) || { seatNo: '', isBooked: false, isSelected: false };
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

  public viewBooked(flightId:any): void {
    this.appService.getbookedSeats(flightId).subscribe(
      (response: any) => {
        this.seatsBooked = response;
        console.table(this.seatsBooked);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }

    );
  }
    
  initializeSeats(): void {
    this.rows.forEach(row => {
      this.cols.forEach(col => {
        const seatNo = row + col;
        console.log(this.seatsBooked);
        console.log(seatNo);
        //const isBooked = this.seatsBooked.includes(seatNo);
        const isBooked = this.seatsBooked.some((bookedSeat: { seatno: any; }) => bookedSeat.seatno=== seatNo);
        console.log(isBooked);
        //const isBooked = Math.random() < 0.3; // Simulating booked seats
        this.seats.push({ seatNo, isBooked, isSelected: false });
      });
    });}

  gotoUserhome(){


  }

  bookTickets(){
   

    let combinedData = {
      passengers: this.selectedPassengers,
      tempseats: this.selectedSeats.map(seat => ({ seatno: seat })) ,
    };
   
    if(this.selectedPassengersCount!=this.selectedSeatsCount){
      alert("Seats selected and passengers selected counts dont match, please try again!");
      localStorage.setItem("userId",this.userId);
    localStorage.setItem("flightId",this.flightId);
    this.router.navigate(['/user-viewFlights']);

    }

   else{this.appService.bookTickets(combinedData,this.flightId).subscribe(
      (response: any) => {
       console.table(response);
       localStorage.setItem("userId",this.userId);
       alert("Your tickets have been booked, redirecting to home page.");
       this.router.navigate(['/user-home']);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }

    );
    }
  }

}
