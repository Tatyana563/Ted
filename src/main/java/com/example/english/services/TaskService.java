package com.example.english.services;

import com.example.english.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskService extends GenericService<Task,Integer> {
    List<Task> findByCatalogHeading(String heading);

}
