package com.cemal.todoproject.controller;


import com.cemal.todoproject.entity.Task;
import com.cemal.todoproject.service.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TaskController {
    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {

        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTask();
        return ResponseEntity.ok(tasks);

    }

    @PostMapping("/addTask")
    public ResponseEntity<Task> addTasks(@Validated @RequestBody Task task) {
        Task task1 = taskService.addTask(task);
        return ResponseEntity.ok(task1);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean>  deleteTask(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@Validated   @RequestBody Task task,@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(taskService.updateTask(task,id));
    }

}
