package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@AllArgsConstructor
//@Setter
//@Getter
public class NewCatalogDto {
    private int catalogId;
    //TODO: sentences are sorted already
    private List<SentenceDto> sentences;
    //TODO: shuffle words
    private List<String> words;

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public List<SentenceDto> getSentences() {
        return sentences;
    }

    public void setSentences(List<SentenceDto> sentences) {
        this.sentences = sentences;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public NewCatalogDto(int catalogId, List<SentenceDto> sentences, List<String> words) {
        this.catalogId = catalogId;
        this.sentences = sentences;
        this.words = words;
    }

    @Override
    public String toString() {
        return "NewCatalogDto{" +
                "catalogId=" + catalogId +
                ", sentences=" + sentences +
                ", words=" + words +
                '}';
    }
}
