package com.example.english.controllers;

import com.example.english.dto.CatalogDto;
import com.example.english.dto.CheckResultDto;
import com.example.english.dto.NewCatalogDto;
import com.example.english.dto.ValidationResult;
import com.example.english.dto.creation.NewArticleRequest;
import com.example.english.dto.creation.Sentence;
import com.example.english.model.Catalog;
import com.example.english.model.Task;
import com.example.english.repositories.CatalogRepository;
import com.example.english.repositories.TaskRepository;
import com.example.english.serviceimpl.MyCustomService;
import com.example.english.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/english")
public class TaskController {

    private final TaskService taskService;
    private final MyCustomService customService;
    private final CatalogRepository catalogRepository;
    private final TaskRepository taskRepository;

    @PostMapping(value = "/validate")
    public ValidationResult validateResponse(@RequestBody CheckResultDto checkResultDto) {

        String wordBySentence = taskService.findWordById(checkResultDto.getSentenceId());
        if (wordBySentence.equals(checkResultDto.getWord())) {
            return new ValidationResult(true);
        }
        return new ValidationResult(false);
    }

    @PostMapping("/task")
    public void createFromPost(@RequestBody Task task) {
        taskService.save(task);
    }

    @PostMapping("/article")
    @Transactional
    public void createFromPost(@RequestBody NewArticleRequest request) {
        //TODO: implement mapper;
        Catalog catalog = new Catalog();
        catalog.setHeading(request.getName());

        Catalog savedCatalog = catalogRepository.save(catalog);

        int index = 0;
        List<Task> tasks = new ArrayList<>();
        for (Sentence sentence : request.getSentences()) {
            Task task = new Task();
            task.setCatalog(savedCatalog);
            task.setIndex(index++);
            task.setSentence(sentence.getText());
            task.setWord(sentence.getWord());
            tasks.add(task);
        }

        taskRepository.saveAll(tasks);
    }

    @GetMapping("/statistic")
    public List<CatalogDto> findStatisticAllArticles() {
        return customService.getCatalogStatistic();
    }


    @GetMapping("/article/{id}")
    public NewCatalogDto findTasksOfArticle(@PathVariable("id") int id) {
        return customService.getTasksByCatalogId_3(id);
    }
}



