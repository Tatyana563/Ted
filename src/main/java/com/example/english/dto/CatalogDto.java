package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//TODO: use lombok annotations, get rid of getters and setters
public class CatalogDto {
    private int id;
    private String heading;
    private long tasksCount;
}