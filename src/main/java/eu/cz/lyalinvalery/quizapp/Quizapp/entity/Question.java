package eu.cz.lyalinvalery.quizapp.Quizapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int complexity;

    private String questionText;

    @ManyToMany(mappedBy = "questions")
    @JsonIgnore
    private List<Quiz> quizzes;

    @OneToMany(mappedBy = "question")
    private List<QuestionChoice> questionChoices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getComplexity() {
        return complexity;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<QuestionChoice> getQuestionChoices() {
        return questionChoices;
    }

    public void setQuestionChoices(List<QuestionChoice> questionChoices) {
        this.questionChoices = questionChoices;
    }


}
