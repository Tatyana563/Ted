package com.example.english.serviceimpl;

import com.example.english.model.Task;
import com.example.english.repositories.TaskRepository;
import com.example.english.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findByCatalogHeading(String heading) {
        return taskRepository.findByCatalogHeading(heading);
    }

    @Override
    @Transactional
    public void createOrUpdate(Task entity) {
        taskRepository.createOrUpdate(entity);
    }

}

