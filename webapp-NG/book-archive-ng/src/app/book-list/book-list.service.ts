import { Injectable } from '@angular/core';
import { Book } from './book';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, pipe, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookListService {
  private bookListUrl = 'http://localhost:8080/api/favoritebooks/';

  constructor(private http: HttpClient) { }

  getBooks(): Observable<Book[]>{
       return this.http.get<Book[]>(this.bookListUrl).pipe(
        tap(data => console.log('All', JSON.stringify(data))),
        catchError(this.handleError)
       );
    }

  private handleError(err: HttpErrorResponse){
        let errorMessage = ' ';
        if(err.error instanceof ErrorEvent){
            errorMessage = `An error occurred: ${err.error.message}`;
        }else{
            errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}` 
        }
        console.log(errorMessage);
        return throwError(() => errorMessage);
    }
}
