package com.example.english.services;

import com.example.english.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<Task> findByCatalogHeading(Integer heading);
    String findWordById(int sentenceId);
    void save(Task task);
}
