package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class NewCatalogDto {
    private int catalogId;
    //TODO: sentences are sorted already
    private List<SentenceDto> sentences;
    //TODO: shuffle words
    private List<String> words;
}
