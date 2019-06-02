package eu.cz.lyalinvalery.quizapp.Quizapp.controller;

import eu.cz.lyalinvalery.quizapp.Quizapp.entity.Result;
import eu.cz.lyalinvalery.quizapp.Quizapp.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lyalin Valeriy (lyalival)
 */
@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    ResultService resultService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Result> getAllQuizs() {
        return resultService.getAllResults();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getQuiz ( @PathVariable Long id ){
        return resultService.getResult(id);
    }

    @RequestMapping(value = "/addQuiz", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result addQuiz(@RequestBody Result result) {
        return resultService.addResult(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteQuiz ( @PathVariable Long id ){
        resultService.deleteResultById(id);
    }
}
