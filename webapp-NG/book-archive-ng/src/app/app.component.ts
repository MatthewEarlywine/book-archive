import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ba-root',
  templateUrl:'./app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  pageTitle = 'Book Archive';

  

  ngOnInit(): void {}

}
