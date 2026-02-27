package com.noxus.task_api.controllers;

import com.noxus.task_api.entities.Task;
import com.noxus.task_api.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task obj) {
        return ResponseEntity.ok(this.taskService.create(obj));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(this.taskService.getAll());
    }
}
