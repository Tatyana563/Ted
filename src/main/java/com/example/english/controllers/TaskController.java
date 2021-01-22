package com.example.english.controllers;

import com.example.english.dto.SentenceRequest;
import com.example.english.dto.ValidationResult;
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

    //http://localhost:9090/english/How to manage your time more effectively (according to machines)
    @GetMapping("/{heading}")
    public ResponseEntity<List<Task>> findByHeading(@PathVariable("heading") String heading) {
        List<Task> tasks = taskService.findByCatalogHeading(heading);
        if (tasks != null) {
            return ResponseEntity.ok(tasks);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/validate")
    public ValidationResult validateResponse(@RequestBody SentenceRequest sentenceRequest) {

        String wordBySentence = taskService.findWordById((sentenceRequest.getSentenceId()));
        if (wordBySentence.equals(sentenceRequest.getWord())) {
            return new ValidationResult(true);
        }
        return new ValidationResult(false);
    }
}



