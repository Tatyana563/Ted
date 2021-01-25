package com.example.english.controllers;

import com.example.english.dto.CatalogDto;
import com.example.english.dto.SentenceRequest;
import com.example.english.dto.ValidationResult;
import com.example.english.model.Task;
import com.example.english.serviceimpl.MyCustomService;
import com.example.english.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //http://192.168.0.1:9090/english/
    //TODO: implement another endpoint with ID param instead of heading.

    @PostMapping(value = "/validate")
    public ValidationResult validateResponse(@RequestBody SentenceRequest sentenceRequest) {

        String wordBySentence = taskService.findWordById((sentenceRequest.getSentenceId()));
        if (wordBySentence.equals(sentenceRequest.getWord())) {
            return new ValidationResult(true);
        }
        return new ValidationResult(false);
    }

    @PostMapping
    public void createFromPost(@RequestBody Task task) {
        taskService.save(task);
    }

    //TODO: implement endpoint for listing all tasks (+ with statistics)
    // use custom dto / map tuples
    // google query: 'hql map to custom dto'

//ResultTransformer
    @GetMapping("/statistic/{heading}")
    public ResponseEntity<List<CatalogDto>> findStatisticByHeading(@PathVariable("heading") Integer id) {
        List<CatalogDto> catalogStatistic = customService.getCatalogStatistic3();
        if (catalogStatistic != null) {
            for (CatalogDto catalogDto : catalogStatistic) {
                System.out.println(catalogDto);
            }
            return ResponseEntity.ok(catalogStatistic);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}



