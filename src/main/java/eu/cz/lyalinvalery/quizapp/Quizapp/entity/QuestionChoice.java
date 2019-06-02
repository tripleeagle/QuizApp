package eu.cz.lyalinvalery.quizapp.Quizapp.entity;

import javax.persistence.*;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Entity
public class QuestionChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String choice;

    private boolean isRight;

    @ManyToOne
    @JoinColumn(name="library_id")
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
