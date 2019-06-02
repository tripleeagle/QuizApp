package eu.cz.lyalinvalery.quizapp.Quizapp.service;

import eu.cz.lyalinvalery.quizapp.Quizapp.dao.QuestionDAO;
import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQuestions  (){
        List questionChoices = new ArrayList<>();
        questionDAO.findAll().forEach(questionChoices::add);
        return questionChoices;
    }

    public Question getQuestion ( Long id ){
        return questionDAO.findById(id).get();
    }

    public Question addQuestion (Question question){
        return questionDAO.save(question);
    }

    public void deleteQuestionById ( Long id ){
        questionDAO.deleteById(id);
    }
}
