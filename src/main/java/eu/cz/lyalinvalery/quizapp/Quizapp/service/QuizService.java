package eu.cz.lyalinvalery.quizapp.Quizapp.service;

import eu.cz.lyalinvalery.quizapp.Quizapp.dao.QuizDAO;
import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    public List<Quiz> getAllQuizzes  (){
        List questionChoices = new ArrayList<>();
        quizDAO.findAll().forEach(questionChoices::add);
        return questionChoices;
    }

    public Quiz getQuiz ( Long id ){
        return quizDAO.findById(id).get();
    }

    public Quiz addQuiz (Quiz quiz){
        return quizDAO.save(quiz);
    }

    public void deleteQuizById ( Long id ){
        quizDAO.deleteById(id);
    }
}
