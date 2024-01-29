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
  cols = [1, 2, 3, 4];
  public userId: any;
  passengers:any=[];

  selectedSeatsCount: number = 0;
selectedPassengersCount: number = 0;

  seats: any[] = [];

  constructor(private router: Router, private route: ActivatedRoute, private appService: UserServiceService) {}

  ngOnInit(): void {
    // Initialization - you may fetch seat data from the server
    // For simplicity, this example initializes some seats as booked
    this.rows.forEach(row => {
      this.cols.forEach(col => {
        const seatNo = row + col;
        const isBooked = Math.random() < 0.3; // Simulating booked seats
        this.seats.push({ seatNo, isBooked, isSelected: false });
      });
    });


    let userId = localStorage.getItem('userId');
    this.userId = userId;
    this.viewPassengers(this.userId);
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

  selectedPassengers: number = 0;

 

  selectSeat(seat: any): void {
    if (this.canSelectSeat(seat)) {
      seat.isSelected = !seat.isSelected;
      this.updateSeatSelection();
      this.selectedSeatsCount += seat.isSelected ? 1 : -1;
    }
  }
  
  canSelectSeat(seat: any): boolean {
    return !seat.isBooked;
  }

  canSelectPassenger(seat: any): boolean {
    if(this.selectedPassengersCount>0){
    return (this.selectedPassengersCount==this.selectedSeatsCount);}
    else return false;
  }
  selectPassenger(passenger: any): void {
    passenger.isSelected = !passenger.isSelected;
    this.selectedPassengersCount += passenger.isSelected ? 1 : -1;
    // Optionally, add any additional logic you need for passenger selection/unselection
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
    
  gotoUserhome(){


  }

}
