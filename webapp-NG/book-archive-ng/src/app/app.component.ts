import { Component } from '@angular/core';

@Component({
  selector: 'ba-root',
  template:`
  <div><h1>{{pageTitle}}</h1></div>
  `
})
export class AppComponent {
  pageTitle = 'Book Archive';
}
