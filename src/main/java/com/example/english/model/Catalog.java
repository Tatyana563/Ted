package com.example.english.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@NamedEntityGraph(
        name = "new-catalog-dto-graph",
        attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode("tasks"),
        }
)

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_catalog")
    @SequenceGenerator(name = "seq_catalog", sequenceName = "catalog_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "heading")
    private String heading;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalog")
    @EqualsAndHashCode.Exclude
    @OrderBy("index ASC")
    private Set<Task> tasks;
}
