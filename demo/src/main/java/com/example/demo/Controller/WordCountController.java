package com.example.demo.Controller;

import com.example.demo.Service.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/word-counter")
public class WordCountController {

    @Autowired
    WordCounterService wordCountService;


    @RequestMapping(method = RequestMethod.POST, value = "/{words}")
    public List<String> addWords(@PathVariable("words") String words)  {
        return wordCountService.addWords(words);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{word}")
    public Long wordCount(@PathVariable("word") String word){
        return wordCountService.wordCount(word);
    }


}
