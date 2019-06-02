package eu.cz.lyalinvalery.quizapp.Quizapp.controller;

import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Question;
import eu.cz.lyalinvalery.quizapp.Quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Question getQuestion ( @PathVariable Long id ){
        return questionService.getQuestion(id);
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Question addQuestion(@RequestBody Question Question) {
        return questionService.addQuestion(Question);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteQuestion ( @PathVariable Long id ){
        questionService.deleteQuestionById(id);
    }
}
