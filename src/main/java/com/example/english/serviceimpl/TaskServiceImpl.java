package com.example.english.serviceimpl;

import com.example.english.model.Task;
import com.example.english.repositories.TaskRepository;
import com.example.english.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public void save(Task entity) {
        taskRepository.save(entity);
    }

    @Override
    public String findWordByIndex(int sentenceId) {
        return taskRepository.findWordById(sentenceId);
    }
}

