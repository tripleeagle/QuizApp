package eu.cz.lyalinvalery.quizapp.Quizapp.controller;

import eu.cz.lyalinvalery.quizapp.Quizapp.entity.QuestionChoice;
import eu.cz.lyalinvalery.quizapp.Quizapp.service.QuestionChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@RestController
@RequestMapping("/questionchoice")
public class QuestionChoiceController {

    @Autowired
    QuestionChoiceService questionChoiceService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<QuestionChoice> getAllQuestionChoices() {
        return questionChoiceService.getAllQuestionChoices();
    }

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public QuestionChoice getQuestionChoice ( @PathVariable Long id ){
        return questionChoiceService.getQuestionChoice(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionChoice addQuestionChoice(@RequestBody QuestionChoice questionChoice) {
        return questionChoiceService.addQuestionChoice(questionChoice);
    }

    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteQuestionChoice ( @PathVariable Long id ){
        questionChoiceService.deleteQuestionChoiceById(id);
    }

    @PutMapping("/replace/{id}")
    QuestionChoice replaceQuestionChoice(@RequestBody QuestionChoice newQuestionChoice, @PathVariable Long id) {
        return questionChoiceService.replaceByID(newQuestionChoice,id);
    }
}
