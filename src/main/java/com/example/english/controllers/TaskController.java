package com.example.english.controllers;

import com.example.english.dto.TaskRequest;
import com.example.english.model.Task;
import com.example.english.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/english")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{catalogHeading}")
    public ResponseEntity<List<Task>> findByHeading(@PathVariable("heading") String heading) {
        List<Task> tasks = taskService.findByCatalogHeading(heading);
        if (tasks != null) {
            return ResponseEntity.ok(tasks);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public void createFromPost(@RequestBody TaskRequest taskRequest) {
        Task taskEntity = taskRequest.convert();
        taskService.createOrUpdate(taskEntity);
    }
}


