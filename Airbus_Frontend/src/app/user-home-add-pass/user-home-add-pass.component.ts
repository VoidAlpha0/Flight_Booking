import { Component , OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { UserServiceService} from 'src/app/services/user-service.service';

@Component({
  selector: 'app-user-addPassenger',
  templateUrl: './user-home-add-pass.component.html',
  styleUrls: ['./user-home-add-pass.component.css']
})
export class UserHomeAddPassComponent implements OnInit{

  constructor(private router: Router, private route: ActivatedRoute, 
    private appService: UserServiceService, private formBuilder: FormBuilder) {}

    public userId: any;

    signupForm!: FormGroup;
  ngOnInit() {
    this.signupForm = new FormGroup({
      passname: new FormControl(null, Validators.required),
      passDOB: new FormControl(null, Validators.required)
    });

}

goBack(){


}


onClickSubmit(formdata: { passname: any; passDOB:any;}, form: { reset: () => void; }) {
  let data={
    passname:formdata.passname,
    passDOB:formdata.passDOB

  };
    this.userId = (localStorage.getItem('userId'));
    console.log('Update fire');
    this.appService.createPassenger(data,this.userId).subscribe(data => {
      alert('Done adding passenger!');
      localStorage.setItem("userId",this.userId);
      this.router.navigate(['/user-home']);
    },
      error => {
        alert("Email id or Employee ID is already present");
      });
  }
}
