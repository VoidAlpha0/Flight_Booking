import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder,FormGroup, Validators } from "@angular/forms";
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit{

  constructor(
    private formBuilder: FormBuilder,
    private service: AdminService,
    private router: Router
  ){}
  ngOnInit(): void {
  }
  locationForm = this.formBuilder.group({
    terminal: [null, Validators.required],
    city: [null, Validators.required],
    country: [null, Validators.required]
  })
  onSubmit() {
    console.log(this.locationForm.value)
    this.service.addLocation(this.locationForm.value).subscribe(
      (      data: any) => {
        console.log(data);
        console.log("locationadded");
        // this.router.navigate(["/locationList"]);
      },
      (      error: any) => {
        this.router.navigate(["/error","error occured unable to add"]);
      }
    );
  }

}
