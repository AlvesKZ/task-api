package com.noxus.task_api.services;

import com.noxus.task_api.entities.Task;
import com.noxus.task_api.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Task getById(Long id) {
        return this.taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task update(Long id, Task obj) {
        try {
            Task task = this.taskRepository.getReferenceById(id);
            task.setTitle(obj.getTitle());
            task.setDescription(obj.getDescription());
            task.setCompleted(obj.getCompleted());
            return this.taskRepository.save(task);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Task not found");
        }
    }
}
