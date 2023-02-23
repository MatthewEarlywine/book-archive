import { Injectable } from '@angular/core';
import { Book } from './book';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
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
  
  addBook(book: Book): Observable<Book>{
      const headers = new HttpHeaders({'Content-Type': 'application/json'});
      return this.http.post<Book>(this.bookListUrl + 'saveBook', book, {headers})
      .pipe(
          tap(data => console.log('added book: ' + JSON.stringify(data))),
          catchError(this.handleError)
      );
  }

  

  deleteBook(id: number): Observable<{}>{
        const headers = new HttpHeaders({'Content-Type': 'application/json'});
        const url = `${this.bookListUrl}delete/${id}`;
        return this.http.delete<Book>(url, {headers})
        .pipe(
            tap(data => console.log('deleted book: ' + id)),
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
