package eu.cz.lyalinvalery.quizapp.Quizapp.dao;

import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Quiz;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lyalin Valeriy (lyalival)
 */
public interface QuizDAO extends CrudRepository<Quiz,Long> {
}
