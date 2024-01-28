import { Component , OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { UserServiceService} from 'src/app/services/user-service.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-home-update-user.component.html',
  styleUrls: ['./user-home-update-user.component.css']
})
export class UserHomeUpdateUserComponent implements OnInit {

 

  constructor(private router: Router, private route: ActivatedRoute, 
    private appService: UserServiceService, private formBuilder: FormBuilder) {}

    public userId: any;

    signupForm!: FormGroup;
  ngOnInit() {
    this.signupForm = new FormGroup({
      username: new FormControl(null, Validators.required),
      userphonenumber: new FormControl(null, Validators.required),
      passwd: new FormControl(null, Validators.required)
    });

}

goBack(){


}


onClickSubmit(formdata: { username: any; userphonenumber:any; passwd: any; }, form: { reset: () => void; }) {
  let data={
    username:formdata.username,
    userphonenumber:formdata.userphonenumber,
    userpassword:formdata.passwd

  };
    this.userId = (localStorage.getItem('userId'));
    console.log('Update fire');
    this.appService.updateUser(data,this.userId).subscribe(data => {
      alert('Done with update!');
      localStorage.setItem("userId",this.userId);
      this.router.navigate(['/user-home']);
    },
      error => {
        alert("Email id or Employee ID is already present");
      });
  }

}
