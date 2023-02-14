import { Injectable } from '@angular/core';
import { Book } from './book';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, pipe, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookListService {
  private bookListUrl = 'http://localhost:8081/api/favoritebooks/';

  constructor(private http: HttpClient) { }


}
