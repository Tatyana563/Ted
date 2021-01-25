package com.example.english.repositories;

import com.example.english.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("from Task as t INNER JOIN t.catalog c where c.id=:id")
    List<Task> findByCatalogHeading(@Param("id") Integer heading);

    @Query("select t.word from  Task as t where t.id=:sentenceId")
    String findWordById(int sentenceId);
}

