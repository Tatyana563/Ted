package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private int catalogId;
    private int index;
    private String sentence;
    private String word;
}
