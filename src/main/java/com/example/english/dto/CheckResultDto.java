package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CheckResultDto {
    private int sentenceId;
    private String word;
}
