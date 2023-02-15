import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'ba-root',
  template:`
  <div><h1>{{pageTitle}}</h1></div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  pageTitle = 'Book Archive';

  loginForm: FormGroup;

  constructor(){
    this.loginForm = new FormGroup({
      Username: new FormControl(null, [Validators.required]),
      Password: new FormControl(null, [Validators.required])
    })
  }

  login(){
    console.log(this.loginForm.value);
  }

  ngOnInit(): void {}

}
