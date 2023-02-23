import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { matchpassword } from './matchpassword.validator';

@Component({
  selector: 'ba-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css'],
})
export class LogInComponent {
  errorMessage = "Both User Name and Password must be present and be at least eight (8) characters long."
  
  loginForm: FormGroup;

  constructor(private router: Router){
    this.loginForm = new FormGroup({
      username: new FormControl(null, [Validators.required, Validators.minLength(8), Validators.pattern(".*\\S.*[a-zA-z0-9 ]")]),
      password: new FormControl(null, [Validators.required, Validators.minLength(8), Validators.pattern(".*\\S.*[a-zA-z0-9 ]")]),
    },
    {
      validators: matchpassword
    })
  }

  login(){
    console.log(this.loginForm.value);
  }

  onClick(): void {
    this.router.navigate(['/home']);
  }
}
