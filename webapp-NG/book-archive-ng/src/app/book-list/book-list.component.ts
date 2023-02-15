import { Component } from '@angular/core';
import { Book } from './book';

@Component({
  selector: 'ba-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent{
  error: string = "The Username and/or Password is faulty. Please try again.";
  books: Book[] = [];
}
