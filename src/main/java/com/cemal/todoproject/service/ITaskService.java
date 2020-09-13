package com.cemal.todoproject.service;

import com.cemal.todoproject.entity.Task;

import java.util.List;

public interface ITaskService {
     List<Task> getAllTask();
     Task addTask();
     Boolean deleteTask();
     Task updateTask();
}
