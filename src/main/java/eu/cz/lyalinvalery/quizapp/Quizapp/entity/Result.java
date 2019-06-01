package eu.cz.lyalinvalery.quizapp.Quizapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String unsername;

    private double score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
