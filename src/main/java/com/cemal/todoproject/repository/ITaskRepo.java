package com.cemal.todoproject.repository;

import com.cemal.todoproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepo  extends JpaRepository<Task,Long> {
}
