package com.example.english.services;

import com.example.english.model.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    String findWordByIndex(int sentenceId);

    void save(Task task);
}
