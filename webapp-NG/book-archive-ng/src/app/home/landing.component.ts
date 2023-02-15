import { Component } from '@angular/core';

@Component({
  selector: 'ba-landing',
  template:`
            <div><h1>Welcome to the {{pageTitle}}!</h1></div>
  `,
  styleUrls: ['./landing.component.css']
})
export class LandingComponent {
  pageTitle: string = 'Favorite Book Listing';
}
