package com.cemal.todoproject.service;

import com.cemal.todoproject.entity.Task;
import com.cemal.todoproject.entity.TaskDetail;
import com.cemal.todoproject.entity.TaskStatus;
import com.cemal.todoproject.repository.ITaskRepo;
import com.cemal.todoproject.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        task.setTaskStatus(TaskStatus.TODO);
        return taskRepo.save(task);
    }

    @Override
    public Boolean deleteTask(Long id) {
        taskRepo.deleteById(id);
        if(taskRepo.findById(id).equals(id)) {
            throw new NotFoundException("Task not delete with id " + id);
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

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> getTask= taskRepo.findById(id);
       if (!getTask.isPresent()) {
           throw new NotFoundException("Task not found with id " + id);
       }
       return getTask.get();
    }
}
