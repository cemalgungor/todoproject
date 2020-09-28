import {ITaskDetail} from "./task-detail-model";
import {TaskStatusModel} from "./task-status-model";

export interface ITask {
  id?: number;
  title?: string;
  taskStatus?: TaskStatusModel;
  taskDetail?: ITaskDetail;
}

export class TaskModel implements ITask {
  constructor(
    public id?: number,
    public title?: string,
    public taskStatus?: TaskStatusModel,
    public taskDetail?: ITaskDetail
  ) {}
}
