package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
//@AllArgsConstructor
public class CheckResultDto {
    private int sentenceId;
    private String word;

    public int getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public CheckResultDto(int sentenceId, String word) {
        this.sentenceId = sentenceId;
        this.word = word;
    }

    public CheckResultDto() {
    }
}
