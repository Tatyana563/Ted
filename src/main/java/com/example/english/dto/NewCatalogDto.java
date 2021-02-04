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
    private List<SentenceDto> sentences;
    private List<String> words;

    @Override
    public String toString() {
        return "NewCatalogDto{" +
                "catalogId=" + catalogId +
                ", sentences=" + sentences +
                ", words=" + words +
                '}';
    }
}
