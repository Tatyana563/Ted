package com.example.english.dto;

import com.example.english.model.Catalog;
import com.example.english.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private Catalog catalog;
    private int id;
    private String sentence;
    private String word;

    public Task convert() {
        final Task task = new Task();
        task.setId(this.id);
        task.setSentence(this.sentence);
        task.setWord(this.word);
        task.setCatalog(catalog);
        return task;
    }
}
