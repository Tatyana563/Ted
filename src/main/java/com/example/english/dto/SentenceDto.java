package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SentenceDto {
    int id;
    String sentence;

    @Override
    public String toString() {
        return "SentenceDto{" +
                "id=" + id +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
