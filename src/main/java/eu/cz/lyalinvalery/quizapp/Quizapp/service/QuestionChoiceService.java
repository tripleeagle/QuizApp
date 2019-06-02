package eu.cz.lyalinvalery.quizapp.Quizapp.service;

import eu.cz.lyalinvalery.quizapp.Quizapp.dao.QuestionChoiceDAO;
import eu.cz.lyalinvalery.quizapp.Quizapp.entity.QuestionChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Service
public class QuestionChoiceService {

    @Autowired
    QuestionChoiceDAO questionChoiceDAO;

    public List<QuestionChoice> getAllQuestionChoices  (){
        List questionChoices = new ArrayList<>();
        questionChoiceDAO.findAll().forEach(questionChoices::add);
        return questionChoices;
    }

    public QuestionChoice getQuestionChoice ( Long id ){
        return questionChoiceDAO.findById(id).get();
    }

    public QuestionChoice addQuestionChoice (QuestionChoice questionChoice){
        return questionChoiceDAO.save(questionChoice);
    }

    public void deleteQuestionChoiceById ( Long id ){
        questionChoiceDAO.deleteById(id);
    }

    public void updateQuestionChoice ( QuestionChoice questionChoice ){
        //TODO
        deleteQuestionChoiceById(questionChoice.getId());
        addQuestionChoice(questionChoice);
    }
}
