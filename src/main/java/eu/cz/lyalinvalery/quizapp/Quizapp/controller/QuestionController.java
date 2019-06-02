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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }


    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public Question getQuestion ( @PathVariable Long id ){
        return questionService.getQuestion(id);
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteQuestion ( @PathVariable Long id ){
        questionService.deleteQuestionById(id);
    }

    @PutMapping("/replace/{id}")
    Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {
        return questionService.replaceByID(newQuestion,id);
    }
}
