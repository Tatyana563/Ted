package com.example.english.dto.creation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewArticleRequest {
    private String name;
    private List<Sentence> sentences;
}
