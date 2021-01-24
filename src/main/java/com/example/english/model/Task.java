package com.example.english.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_task")
    @SequenceGenerator(name = "seq_task", sequenceName = "task_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "sentence")
    private String sentence;

    @Column(name = "word")
    private String word;

    private int index;

    @ManyToOne
    @JoinColumn(name = "fk_catalog_id", nullable = false)
    private Catalog catalog;
}
