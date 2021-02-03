package com.example.english.model;


import com.example.english.dto.SentenceDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.beans.IntrospectionException;
import java.io.Serializable;


@SqlResultSetMapping(
        name="SentenceResult",
        classes={
                @ConstructorResult(
                        targetClass= SentenceDto.class,
                        columns={
                                @ColumnResult(name="id", type= Integer.class),
                                @ColumnResult(name="sentence", type=String.class)
                               })})
@NamedNativeQuery(
        name = "SentenceDto",
        query = " select t.id, t.sentence from Task as t " +
                "    INNER JOIN catalog on t.fk_catalog_id=catalog.id where t.fk_catalog_id=? order by t.index ASC ",
        resultSetMapping = "SentenceResult"
)


@NamedEntityGraph(
        name = "new-catalog-dto-graph",
        attributeNodes = {
                @NamedAttributeNode("sentence"),
                @NamedAttributeNode("word"),
              //  @NamedAttributeNode("catalog"),
        }
)


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

    //TODO: index is unique per catalog
    @Column(name = "index")
    private int index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_catalog_id", nullable = false)
    private Catalog catalog;
}
