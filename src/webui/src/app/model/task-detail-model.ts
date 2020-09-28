
import { Moment } from 'moment';
export interface ITaskDetail {
  id?: number;
  description?: string;
  created_at?: Moment;
  comment?: string;
  commentBy?: string;
}

export class TaskDetailModel implements ITaskDetail {
  constructor(
    public id?: number,
    public description?: string,
    public created_at?: Moment,
    public comment?: string,
    public commentBy?: string
  ) {}
}
