import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService} from 'src/app/services/user-service.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit{
  
  constructor(private router: Router, private appService: UserServiceService) {}
useremail:any;
  signupForm!: FormGroup;
  ngOnInit(): void {
    this.signupForm = new FormGroup({
      email: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required),
    });
  }

  gotoRegister() {
    this.router.navigate(['/user-register']);

  }

  onClickSubmit(formdata: { email: any; passwd: any; }, form: { reset: () => void; }) {
    var userid: Number;
    var incomingpassword: string = '';
    
    
    //this.user_email = formdata.email;
    //this.user_passwd = formdata.passwd;

    this.appService.finduserbyemail(formdata.email).subscribe(
      (data:any) => {
        userid = data.userId;
        incomingpassword = data.userpassword;
        console.log(incomingpassword);
        console.log(data.userpassword);
        if (incomingpassword === formdata.passwd) {
          console.log('correct pass');
          alert('Login successfull');
          this.router.navigate(['/user-home',userid]);
        } else {
          console.log('wrong pass');
          alert('Wrong Password . Enter correct password');
          form.reset();
        }
      },
      (error) => {
        alert('enter correct details');
        form.reset();
      }
    );
  }

  alert(arg0: string) {
    throw new Error('Method not implemented.');
  }
}


