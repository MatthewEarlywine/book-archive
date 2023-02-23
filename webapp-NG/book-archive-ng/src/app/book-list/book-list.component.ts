import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Book } from './book';
import { BookListService } from './book-list.service';
import { bookinfo } from './bookinfo.validator';

@Component({
  selector: 'ba-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit{
  bookError: string = "The Title and/or Author field is faulty. Please try again.";

  bookForm!: FormGroup;
  index: any;

  constructor(private formBuilder: FormBuilder, private bookListService: BookListService) {}

  errorMessage: string = "";
  sub: Subscription = new Subscription;
  books: Book[] = [];

  isError: boolean = false;

  ngOnInit(): void {
      this.bookForm = this.formBuilder.group({
      id: [],
      title: ['', [Validators.required, Validators.minLength(1)]],
      series: [],
      author: ['', [Validators.required, Validators.minLength(1)]],
      illustrator: [],
      genre: []
    },
    {
      validators: bookinfo
    })

   this.sub = this.bookListService.getBooks().subscribe({
      next: (books: Book[]) => this.books = books
    });

  }

  addBook(): void{
    console.log(this.bookForm.value);
    this.bookListService.addBook(this.bookForm.value).subscribe({
      next: () => this.reloadPage(),
      error: err => this.errorMessage = err
    });
    this.reset();
  }

  editBook(book: Book): void{
    this.bookForm.setValue({
      id: book.id, 
      title: book.title, 
      series: book.series, 
      author: book.author, 
      illustrator: book.illustrator, 
      genre: book.genre}) 
  }

  updateBook(): void{
        console.log(this.bookForm.value);
    this.bookListService.addBook(this.bookForm.value).subscribe({
      next: () => this.reloadPage(),
      error: err => this.errorMessage = err

    });
  }

  deleteBook(id: number): void {
    if(confirm('Are you sure you want to delete?')){
      this.bookListService.deleteBook(id).subscribe({
        next: () => this.reloadPage(),
        error: err => this.errorMessage = err
      });
    }

  }

  reloadPage() {
    window.location.reload();
 }

 reset(){
  this.bookForm.reset();
 }

}



