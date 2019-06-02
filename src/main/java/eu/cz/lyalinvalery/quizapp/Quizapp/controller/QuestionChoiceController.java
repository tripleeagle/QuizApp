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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<QuestionChoice> getAllQuestionChoices() {
        return questionChoiceService.getAllQuestionChoices();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public QuestionChoice getQuestionChoice ( @PathVariable Long id ){
        return questionChoiceService.getQuestionChoice(id);
    }

    @RequestMapping(value = "/addquestionchoice", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public QuestionChoice addQuestionChoice(@RequestBody QuestionChoice questionChoice) {
        return questionChoiceService.addQuestionChoice(questionChoice);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteQuestionChoice ( @PathVariable Long id ){
        questionChoiceService.deleteQuestionChoiceById(id);
    }

    @RequestMapping(value = "/updateQuestionChoice", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public void updateQuestionChoice(@RequestBody QuestionChoice questionChoice) {
        questionChoiceService.updateQuestionChoice(questionChoice);
    }
}
