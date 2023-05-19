package com.example.demo.Service;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WordCounterService {
    List<String> addWords(String words);
    Long wordCount(String word);

}


