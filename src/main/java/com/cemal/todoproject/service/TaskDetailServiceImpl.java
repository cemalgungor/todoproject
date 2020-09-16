package com.cemal.todoproject.service;

import com.cemal.todoproject.entity.TaskDetail;
import com.cemal.todoproject.repository.ITaskDetailRepo;
import com.cemal.todoproject.repository.ITaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class TaskDetailServiceImpl implements ITaskDetailService {

    ITaskDetailRepo taskDetailRepo;

    public TaskDetailServiceImpl(ITaskDetailRepo taskDetailRepo) {
        this.taskDetailRepo = taskDetailRepo;
    }

    @Override
    public TaskDetail addTaskDetail(TaskDetail taskDetail,Long id) {

        taskDetailRepo.save(taskDetail);

        return null;
    }

    @Override
    public TaskDetail updateTaskDetailByTaskId(TaskDetail taskDetail,Long id ) {

        TaskDetail _taskDetail=taskDetailRepo.getOne(id);
        _taskDetail.setComment(taskDetail.getComment());
        _taskDetail.setCommentBy(taskDetail.getCommentBy());
        _taskDetail.setCreatedAt(new Date());
        _taskDetail.setDescription(taskDetail.getDescription());
        taskDetailRepo.save(_taskDetail);
        return taskDetailRepo.save(_taskDetail);
    }

    @Override
    public TaskDetail getTaskDetailByIdWithDetails(Long id) {
       TaskDetail taskDetail=taskDetailRepo.getOne(id);
        return taskDetail;
    }

    @Override
    public Boolean deleteTaskDetailByTaskId() {
        return null;
    }
}
