package com.cemal.todoproject.service;

import com.cemal.todoproject.entity.TaskDetail;

public interface ITaskDetailService {
    TaskDetail addTaskDetail();
    TaskDetail updateTaskDetailByTaskId();
    TaskDetail getTaskDetailByTaskId();
    Boolean deleteTaskDetailByTaskId();
}
