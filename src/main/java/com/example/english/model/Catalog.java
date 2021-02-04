package com.example.english.model;

import lombok.*;

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
//@Setter
//@Getter
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
    private Set<Task> tasks;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
