package com.example.english.mappers;

import com.example.english.dto.NewCatalogDto;
import com.example.english.dto.SentenceDto;
import com.example.english.model.Catalog;
import com.example.english.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface NewCatalogDtoMapper {

    @Mapping(target = "catalogId", source = "id")
    @Mapping(target = "sentences", source = "tasks")
    @Mapping(target = "words", expression = "java(wordsFromTasks(catalog.getTasks()))")
    NewCatalogDto fromEntity(Catalog catalog);

    SentenceDto sentenceFromTask(Task task);

    default String wordFromTask(Task task) {
        return task == null ? null : task.getWord();
    }

    //TODO: shuffle words
    List<String> wordsFromTasks(Set<Task> task);
}
