package com.example.english.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@NamedEntityGraph(
        name = "new-catalog-dto-graph",
        attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode("tasks"),
                //  @NamedAttributeNode("catalog"),
        }
)

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

//    @OneToMany(mappedBy = "catalog")
//    private Set<Task> tasks;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_catalog_id", nullable = false)
    private Set<Task> tasks;
}
