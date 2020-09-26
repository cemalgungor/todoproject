import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) {
  }

  get(path: string): Observable<any> {
    return this.http.get( path, httpOptions);
  }

  post(path: string, payload: any): Observable<any> {
    return this.http.post( path, payload, httpOptions);
  }

  put(path: string, payload: any): Observable<any> {
    return this.http.put( path, payload, httpOptions);
  }

  delete(path: string): Observable<any> {
    return this.http.delete( path, httpOptions);
  }

}
