
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../services/admin.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})


export class AdminLoginComponent implements OnInit {
  loginForm: FormGroup;
  failure = { value: false };
  adminData = null;

  constructor(
    private fb: FormBuilder,
    private adminService: AdminService,
    private router: Router) {
    // Initialize the form with form controls and their validation rules
    this.loginForm = this.fb.group({
      adminemail: ['', Validators.required],
      adminpassword: ['', [Validators.required, Validators.minLength(8)]]
    });
  }

  ngOnInit(): void {
    // You can perform any additional initialization logic here
  }

  submit(): void {
    // Perform login logic here
    console.log('Form values before submission:', this.loginForm.value);
    if (this.loginForm.valid) {
      this.adminService.adminLogin(this.loginForm.value).subscribe(
        (data: any) => {
          if (data && data.adminemail) {
            const adminEmail = data.email;
            this.failure.value = false;
            localStorage.setItem("adminEmail", adminEmail);
            this.router.navigate(["/adminHome"]);
            console.log('Form submitted:', this.loginForm.value);
            console.log("fucking logged in finally")
            this.router.navigate(['/admin']);
          } else {
            console.log("no data got");
          }
        },
        (error) => {
          this.failure.value = true;
          this.loginForm.reset();
        } // Closing parenthesis was missing here
      );
    } else {
      this.failure.value = true;
    }
  }
  
}