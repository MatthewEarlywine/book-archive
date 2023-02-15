import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { matchpassword } from './matchpassword.validator';

@Component({
  selector: 'ba-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent {
  
  
  loginForm: FormGroup;

  constructor(){
    this.loginForm = new FormGroup({
      username: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required]),
      confirmPassword: new FormControl(null)
    },
    {
      validators: matchpassword
    })
  }

  login(){
    console.log(this.loginForm.value);
  }
}
