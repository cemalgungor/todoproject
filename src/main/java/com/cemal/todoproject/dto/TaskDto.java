package com.cemal.todoproject.dto;

import com.cemal.todoproject.entity.TaskDetail;
import com.cemal.todoproject.entity.TaskStatus;
import com.cemal.todoproject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private TaskStatus taskStatus;
    private Long detailId;
    private UserDto user;
}
