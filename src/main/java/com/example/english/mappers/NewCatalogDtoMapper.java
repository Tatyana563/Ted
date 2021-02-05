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
    @Mapping(target = "words", expression = "java(tasksToWords(catalog.getTasks()))")
    @Mapping(target = "catalogId", source = "id")
    @Mapping(target = "sentences", source = "tasks")
    NewCatalogDto catalogToCatalogDto(Catalog catalog);

    SentenceDto taskToSentenceDto(Task task);

    default String taskToWord(Task task) {
        return task.getWord();
    }

    List<String> tasksToWords(Set<Task> tasks);
}
