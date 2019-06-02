package eu.cz.lyalinvalery.quizapp.Quizapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String unsername;

    private double score;

    @ManyToOne
    @JoinColumn(name="quiz_id")
    @JsonIgnore
    private Quiz quiz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnsername() {
        return unsername;
    }

    public void setUnsername(String unsername) {
        this.unsername = unsername;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
