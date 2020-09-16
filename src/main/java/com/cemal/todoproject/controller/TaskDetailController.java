package com.cemal.todoproject.controller;
import com.cemal.todoproject.entity.Task;
import com.cemal.todoproject.entity.TaskDetail;
import com.cemal.todoproject.service.ITaskDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/task-detail")
public class TaskDetailController {
    ITaskDetailService taskDetailService;

    public TaskDetailController(ITaskDetailService taskDetailService) {
        this.taskDetailService = taskDetailService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDetail> getDetailById(@PathVariable(value = "id") Long id ){
        TaskDetail taskDetail= taskDetailService.getTaskDetailByIdWithDetails(id);
        return ResponseEntity.ok(taskDetail);
    }
    @PostMapping
    public ResponseEntity<TaskDetail> addTaskDetail(@Validated @RequestBody TaskDetail taskDetail,@PathVariable(value = "id") Long id  ){
        return ResponseEntity.ok(taskDetailService.addTaskDetail(taskDetail,id));
    }

}
