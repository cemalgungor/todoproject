import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Observable, of  } from 'rxjs';
import {ITask} from "../model/task-model";
import {catchError, map} from "rxjs/operators";
@Injectable({ providedIn: 'root' })
export class TaskService {
  constructor(protected http: HttpClient) {}
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAllTask(): Observable<ITask[]> {
    return this.http.get('http://localhost:8080/api/tasks' ).pipe(
      map((res) => {
        console.log(res);
        return <ITask[]> res
      })
    )
  }
  addTask1(task:ITask) :Observable<any> {

      return this.http.post<ITask>('http://localhost:8080/api/addTask',task,
        this.httpOptions).pipe(catchError(this.formatError));

  }
  addTask(task: string): Observable<any> {
    const body = { title:task };
    return this.http.post( 'http://localhost:8080/api/addTask',  body , this.httpOptions);
  }
  deleteTask(id: number): Observable<any> {

    return this.http.delete( 'http://localhost:8080/api/delete/'+id,  this.httpOptions);
  }
  updateTaskStatus(id: number, taskStatus:number): Observable<any> {
    const body = { taskStatus:taskStatus };
    return this.http.put( 'http://localhost:8080/api/updateStatus/'+id+"/"+taskStatus,  this.httpOptions);
  }

  private formatError(error: any) {
    return of("http://localhost:8000/api" + error.error);
  }
}
