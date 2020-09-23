import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TaskComponent} from "./pages/task/task.component";


const routes: Routes = [
  {path: '', component: TaskComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
