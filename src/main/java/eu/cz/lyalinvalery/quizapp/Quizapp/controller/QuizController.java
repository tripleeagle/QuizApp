package eu.cz.lyalinvalery.quizapp.Quizapp.controller;

import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Question;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public Quiz getQuiz ( @PathVariable Long id ){
        return quizService.getQuiz(id);
    }

    @RequestMapping(value = "/addQuiz", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteQuiz ( @PathVariable Long id ){
        quizService.deleteQuizById(id);
    }

    @PutMapping("/replace/{id}")
    Quiz replaceQuiz(@RequestBody Quiz newQuiz, @PathVariable Long id) {
        return quizService.replaceByID(newQuiz,id);
    }
}
