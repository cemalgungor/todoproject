package com.cemal.todoproject.repository;

import com.cemal.todoproject.entity.TaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskDetailRepo extends JpaRepository<TaskDetail,Long> {
}
