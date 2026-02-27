package com.noxus.task_api.services;

import com.noxus.task_api.entities.Task;
import com.noxus.task_api.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task create(Task obj) {
        return this.taskRepository.save(obj);
    }

    public List<Task> getAll() {
        return this.taskRepository.findAll();
    }
}
