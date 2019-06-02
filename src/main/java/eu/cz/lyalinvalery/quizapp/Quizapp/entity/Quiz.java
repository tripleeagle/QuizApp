package eu.cz.lyalinvalery.quizapp.Quizapp.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    private double minPercentage;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "quiz_question",
            joinColumns = @JoinColumn(name = "quiz_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"))
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    private List<Result> results;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMinPercentage() {
        return minPercentage;
    }

    public void setMinPercentage(double minPercentage) {
        this.minPercentage = minPercentage;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
