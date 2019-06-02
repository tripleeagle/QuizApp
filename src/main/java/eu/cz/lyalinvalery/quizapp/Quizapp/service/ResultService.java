package eu.cz.lyalinvalery.quizapp.Quizapp.service;

import eu.cz.lyalinvalery.quizapp.Quizapp.dao.ResultDAO;
import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Quiz;
import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@Service
public class ResultService {

    @Autowired
    ResultDAO resultDAO;

    public List<Result> getAllResults  (){
        List questionChoices = new ArrayList<>();
        resultDAO.findAll().forEach(questionChoices::add);
        return questionChoices;
    }

    public Result getResult ( Long id ){
        return resultDAO.findById(id).get();
    }

    public Result addResult (Result result){
        return resultDAO.save(result);
    }

    public void deleteResultById ( Long id ){
        resultDAO.deleteById(id);
    }

    public Result replaceByID (Result newResult, Long id){
        return resultDAO.findById(id)
                .map(result -> {
                    result.setScore(newResult.getScore());
                    result.setUserName(newResult.getUserName());
                    result.setQuiz(newResult.getQuiz());
                    return resultDAO.save(result);
                })
                .orElseGet(() -> {
                    newResult.setId(id);
                    return resultDAO.save(newResult);
                });
    }
}
