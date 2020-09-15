package com.cemal.todoproject.service;

import com.cemal.todoproject.entity.Task;

import java.util.List;

public interface ITaskService {
     List<Task> getAllTask();
     Task addTask(Task task);
     Boolean deleteTask(Long id);
     Task updateTask(Task task, Long id);
}
