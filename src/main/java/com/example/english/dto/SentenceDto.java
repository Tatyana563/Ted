package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class SentenceDto {
    int id;
    String sentence;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public SentenceDto(int id, String sentence) {
        this.id = id;
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "SentenceDto{" +
                "id=" + id +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
