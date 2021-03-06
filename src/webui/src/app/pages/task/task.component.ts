import { Component, OnInit } from '@angular/core';
import {ITask} from "../../model/task-model";
import {HttpResponse} from "@angular/common/http";
import {TaskService} from "../../service/task.service";
import {map} from "rxjs/operators";
import {TaskStatusModel} from "../../model/task-status-model";

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent implements OnInit {
  task?: ITask[];
  todo?: ITask[];
  doing?: ITask[];
  done?: ITask[];


  constructor(protected taskService: TaskService) {


  }

  ngOnInit(): void {
    this.loadAll();

  }

  loadAll(): void {

    this.taskService.getAllTask().subscribe((task: ITask[]) => this.task = task);
    this.todo = (this.task|| []).filter(item => item.taskStatus === 0);
    this.doing = (this.task|| []).filter(item => item.taskStatus === 1);
    this.done = (this.task|| []).filter(item => item.taskStatus === 2);
    console.log(this.todo);

  }
  addTask(task): void{
     console.log(task);
    this.taskService
      .addTask(task)
      .subscribe(task => this.task.push(task) ,  error => { console.log(error) });

  }
  updateTaskStatus(id:number,taskStatus:TaskStatusModel): void{

    this.taskService
      .updateTaskStatus(id,taskStatus)
      .subscribe((data)=>{
          const deletedTask = this.task.find(x => x.id === id);
          console.log(deletedTask);
          this.task.splice(this.task.indexOf(deletedTask), 1);
          console.log(deletedTask);
          this.task.push(data);
          console.log(data);


        }
      );

  }
  deleteTask(id:number) {
    return this.taskService.deleteTask(id).subscribe( (data)=>{
    const deletedTask = this.task.find(x => x.id === id);
    console.log(deletedTask);
    this.task.splice(this.task.indexOf(deletedTask), 1);

  }
    );
  }


}
