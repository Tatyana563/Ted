package com.example.english.repositories;

import com.example.english.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("from Task as t where Catalog.heading=:heading")
    List<Task> findByCatalogHeading(@Param("heading") String heading);
    @Modifying
    void createOrUpdate(Task task);
}
