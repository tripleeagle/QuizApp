package eu.cz.lyalinvalery.quizapp.Quizapp.controller;

import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Quiz;
import eu.cz.lyalinvalery.quizapp.Quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    QuizService quizService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Quiz> getAllQuizs() {
        return quizService.getAllQuizzes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Quiz getQuiz ( @PathVariable Long id ){
        return quizService.getQuiz(id);
    }

    @RequestMapping(value = "/addQuiz", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Quiz addQuiz(@RequestBody Quiz Quiz) {
        return quizService.addQuiz(Quiz);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteQuiz ( @PathVariable Long id ){
        quizService.deleteQuizById(id);
    }
}
