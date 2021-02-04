package com.example.english.model;


import com.example.english.dto.SentenceDto;
import lombok.*;

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
@EqualsAndHashCode
//@Setter
//@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_catalog_id", nullable = false)
    private Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
