import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Book } from './book';
import { BookListService } from './book-list.service';

@Component({
  selector: 'ba-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit{
  bookError: string = "The Title and/or Author field is faulty. Please try again.";

  constructor(private formBuilder: FormBuilder, private bookListService: BookListService) { }

  bookForm: FormGroup | undefined;

  errorMessage: string = "";
  sub: Subscription = new Subscription;
  books: Book[] = [];
  newBook!: Book;
  book!: Book;
  isError: boolean = false;

  ngOnInit(): void {

   this.bookForm = this.formBuilder.group({
    id: null,
    title:'',
    series:'',
    author:'',
    illustrator:'',
    genre:''
   })

   this.sub = this.bookListService.getBooks().subscribe({
      next: (books: Book[]) => this.books = books
    });

  }

  onSubmit(): void{
    if((this.book.title = '') || (this.book.author = '')){
      this.isError = true;
    }
  }
}
