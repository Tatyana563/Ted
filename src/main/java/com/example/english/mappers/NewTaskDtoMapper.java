package com.example.english.mappers;

import com.example.english.dto.creation.Sentence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewTaskDtoMapper {
    //TODO: implement mappers for article creation.

    @Mapping(target = "sentence", expression = "java(tasksToWords(newArticleRequest.getSentences()))")
    @Mapping(target = "sentence", expression = "java(sentencesToWords(newArticleRequest.getSentences()))")


    default String sentenceToText(Sentence sentence) {
        return sentence.getText();
    }

    List<String> sentencesToTexts(List<Sentence> sentences);


    @Named(value = "useMe")
    default String sentenceToWord(Sentence sentence) {
        return sentence.getWord();
    }

    List<String> sentencesToWords(List<Sentence> sentences);

}