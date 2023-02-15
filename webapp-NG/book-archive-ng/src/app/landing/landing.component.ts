import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'ba-landing',
  template:`
            <div class="belch"><br><br><h1>Welcome to the {{pageTitle}}!</h1><br>
            
            <br><br>
            <div><button (click)='onClick()'>To the List!</button><br><br></div></div>
  `,
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit{
  pageTitle: string = 'Favorite Book Listing';

  constructor(private route: ActivatedRoute,
              private router: Router){ }
  ngOnInit(): void {
    this.pageTitle = 'List';
  }

  onClick(): void {
    this.router.navigate(['/list']);
  }

}
