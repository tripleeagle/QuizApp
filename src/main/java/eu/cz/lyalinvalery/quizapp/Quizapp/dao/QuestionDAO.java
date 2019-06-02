package eu.cz.lyalinvalery.quizapp.Quizapp.dao;

import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lyalin Valeriy (lyalival)
 */
public interface QuestionDAO extends CrudRepository<Question,Long> {
}
