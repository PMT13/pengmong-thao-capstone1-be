package net.yorksolutions.pengmongthaocapstone1be.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    @OneToMany(orphanRemoval = true)
    private Set<Question> questionSet;

    public Survey(String title) {
        this.title = title;
        this.questionSet = new HashSet<>();
    }

    public Survey() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
