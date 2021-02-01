package com.example.english.repositories;

import com.example.english.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("select t.word from  Task as t where t.id=:sentenceId")
    String findWordById(int sentenceId);

}

