import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BookListComponent } from './book-list/book-list.component';
import { HomepageComponent } from './home/homepage.component';
import { LandingComponent } from './home/landing.component';
import { LogInComponent } from './home/log-in.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    HomepageComponent,
    LandingComponent,
    LogInComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
