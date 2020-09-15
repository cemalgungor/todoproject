package com.cemal.todoproject.service;

import com.cemal.todoproject.entity.Task;
import com.cemal.todoproject.entity.TaskDetail;
import com.cemal.todoproject.repository.ITaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepo taskRepo;


    public TaskServiceImpl(ITaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public List<Task> getAllTask() {

        return taskRepo.findAll();
    }

    @Override
    public Task addTask(Task task) {
        TaskDetail td = new TaskDetail();
        td.setId(task.getId());
        task.setTaskDetail(td);
        return taskRepo.save(task);
    }

    @Override
    public Boolean deleteTask(Long id) {
        taskRepo.deleteById(id);
        if(taskRepo.findById(id).equals(id)) {
            return null;
        }
        return true;
    }

    @Override
    public Task updateTask(Task task, Long id) {

        Task taskupdate= taskRepo.getOne(id);
        taskupdate.setTaskStatus(task.getTaskStatus());
        taskupdate.setTitle(task.getTitle());
        return taskRepo.save(taskupdate);
    }
}
