import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, ParamMap, Router } from "@angular/router";
import { AdminService } from "../services/admin.service";
import {location} from "../model/location";


@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  

  destinations: string[] = [
    'Destination 1',
    'Destination 2',
    'Destination 3',
    // Add more destination options here
  ];

  departureDestinations: string[] = [
    'Departure 1',
    'Departure 2',
    'Departure 3',
    // Add more departure destination options here
  ];


  

  adminemail =null;
  adminDetails = null;
  flightNumber = null;

  flightForm = this.formBuilder.group({
    // flightsource: [null,Validators.required],
    // flightdestination: [null,Validators.required],
    departureDate: [null, [Validators.required,this.departureDateValidator]],
    departureTime: [null, Validators.required],
    arrivalDate: [null, [Validators.required,this.arrivalDateValidator]],
    arrivalTime: [null, Validators.required],
    price: [null, [Validators.required,Validators.min(1),Validators.max(10000)]],


    dropdownChoice: [null, Validators.required],
  })
  // validator method for departure date 
  departureDateValidator(control: AbstractControl) {
    const inputDate = new Date(control.value);
    const currentDate = new Date();
    if (inputDate < currentDate) {
      return { dateError: true };
    }
    return null;
  }
  /* ----validator method for arrival date---------- */
  arrivalDateValidator(control: AbstractControl){
    const depDate = control.get('departureDate');
    const arrDate = control.get('arrivalDate');
    if( depDate && arrDate && new Date(depDate.value) > new Date(arrDate.value)){
      return {arrivalDateError : true};
    }
    else {
      return null;
    }
  }

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private adminService: AdminService
  ) {}

  ngOnInit(): void {
    let response = this.adminService.getLocations();
    response.subscribe((data:any)=>this.locations=data);
  }
  
  


  // onSubmit() {
  // const formData = this.flightForm.value;
  // console.log('Form Data:', formData);
  //   this.adminService.addFlight(this.flightForm.value).subscribe(
  //     data => {
  //       console.log(data);
  //       this.router.navigate(["/adminHome"]);
  //     }
  //   );
  // }


  locations: location[] =[]
  formatLocation(location: any): string {
    return `${location.city} Terminal: ${location.terminal}  Country: ${location.country}`;
  }
  
  onSubmit() {
    const formData = this.flightForm.value;
    const dropdownChoiceValue = this.flightForm.get('dropdownChoice')?.value;
  
    console.log('Form Data:', formData);
    console.log('Dropdown Choice Value (locId):', dropdownChoiceValue);
  
    if (dropdownChoiceValue !== null && dropdownChoiceValue !== undefined) {
      // Send both formData and dropdownChoiceValue to adminService
      this.adminService.addFlight(formData, dropdownChoiceValue).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['/adminHome']);
        }
      );
    } else {
      console.error('Dropdown Choice Value is null or undefined. Cannot proceed with the submission.');
      // Handle the error or provide appropriate feedback to the user
    }
  }
  
  
}
