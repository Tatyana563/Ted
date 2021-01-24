package com.example.english.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_catalog")
    @SequenceGenerator(name = "seq_catalog", sequenceName = "catalog_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "heading")
    private String heading;

    //TODO: add relation to tasks (define relation owner)
}
