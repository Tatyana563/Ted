package com.example.english.repositories;

import com.example.english.dto.SentenceDto;
import com.example.english.model.Task;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("select t.word from  Task as t where t.id=:sentenceId")
    String findWordById(int sentenceId);

    @Query("select t.word from Task as t where t.catalog.id=:catalogId ")
    List<String> findWordsByCatalogId (int catalogId);

    @Query(" select new com.example.english.dto.SentenceDto (t.id, t.sentence) from Task as t where t.catalog.id=:catalogId order by t.index ASC ")
    List<SentenceDto> findSentenceDtoByCatalogId (int catalogId);


}

