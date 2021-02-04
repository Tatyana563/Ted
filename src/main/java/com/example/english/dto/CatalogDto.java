package com.example.english.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class CatalogDto {
    private int id;
    private String heading;
    private long tasksCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public long getTasksCount() {
        return tasksCount;
    }

    public void setTasksCount(long tasksCount) {
        this.tasksCount = tasksCount;
    }

    public CatalogDto(int id, String heading, long tasksCount) {
        this.id = id;
        this.heading = heading;
        this.tasksCount = tasksCount;
    }

    public CatalogDto() {
    }
}