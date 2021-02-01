package com.example.english.controllers;

import com.example.english.dto.CatalogDto;
import com.example.english.dto.SentenceRequest;
import com.example.english.dto.TaskRequest;
import com.example.english.dto.ValidationResult;
import com.example.english.model.Task;
import com.example.english.serviceimpl.MyCustomService;
import com.example.english.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/english")
public class TaskController {

    private final TaskService taskService;
    private final MyCustomService customService;

    public TaskController(TaskService taskService, MyCustomService customService) {
        this.taskService = taskService;
        this.customService = customService;
    }


    @PostMapping(value = "/validate")
    public ValidationResult validateResponse(@RequestBody SentenceRequest sentenceRequest) {

        String wordBySentence = taskService.findWordByIndex((sentenceRequest.getSentenceIndex()));
        if (wordBySentence.equals(sentenceRequest.getWord())) {
            return new ValidationResult(true);
        }
        return new ValidationResult(false);
    }

    @PostMapping
    public void createFromPost(@RequestBody Task task) {
        taskService.save(task);
    }

    //TODO: implement another endpoint with ID param instead of heading.
    //TODO: implement endpoint for requesting single catalogDto

    @GetMapping("/statistic")
    public List<CatalogDto> findStatisticAllArticles() {
        return customService.getCatalogStatistic();
    }

    @GetMapping("/statistic/{id}")
    public List<CatalogDto> findStatisticOfArticle(@PathVariable("id") int id) {
        return customService.getTaskCountByCatalogId(id);
    }

    @GetMapping("/tasks/{id}")
    public List<TaskRequest> findTasksOfArticle(@PathVariable("id") int id) {
        return customService.getTasksByCatalogId(id);
    }


}



