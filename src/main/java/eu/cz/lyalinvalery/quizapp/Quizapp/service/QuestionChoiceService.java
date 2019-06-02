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

    public QuestionChoice replaceByID ( QuestionChoice newQuestionChoice, Long id){
        return questionChoiceDAO.findById(id)
                .map(qChoice -> {
                    qChoice.setQuestion(newQuestionChoice.getQuestion());
                    qChoice.setRight(newQuestionChoice.isRight());
                    qChoice.setChoiceText(newQuestionChoice.getChoiceText());
                    return questionChoiceDAO.save(qChoice);
                })
                .orElseGet(() -> {
                    newQuestionChoice.setId(id);
                    return questionChoiceDAO.save(newQuestionChoice);
                });
    }
}
