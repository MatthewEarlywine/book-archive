import { Component } from '@angular/core';
import { Book } from './book';

@Component({
  selector: 'ba-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent{
  bookError: string = "The Title and/or Author field is faulty. Please try again.";
  books: Book[] = [];
}
