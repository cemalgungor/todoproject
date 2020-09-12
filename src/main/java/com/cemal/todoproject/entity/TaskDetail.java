package com.cemal.todoproject.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TASK_MODEL_DETAIL")
public class TaskDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;
    @Column(name = "comment")
    private String comment;
    @Column(name = "comment_by")
    private String commentBy;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;
}
