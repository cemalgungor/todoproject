package com.cemal.todoproject.service;

import com.cemal.todoproject.entity.TaskDetail;

public interface ITaskDetailService {
    TaskDetail addTaskDetail(TaskDetail taskDetail,Long id );
    TaskDetail updateTaskDetailByTaskId(TaskDetail taskDetail,Long id );
    TaskDetail getTaskDetailByIdWithDetails(Long id);
    Boolean deleteTaskDetailByTaskId();
}
