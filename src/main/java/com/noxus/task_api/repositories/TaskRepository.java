package com.noxus.task_api.repositories;

import com.noxus.task_api.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
