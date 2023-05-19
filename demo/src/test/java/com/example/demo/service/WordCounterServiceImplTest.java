package com.example.demo.service;

import com.example.demo.Service.WordCounterService;
import com.example.demo.Service.WordCounterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class WordCounterServiceImplTest {

    @Autowired
    WordCounterService wordCounterService;

    @Test
    @Order(1)
    public void addEmptyWordsTest(){
        Throwable ex = Assertions.assertThrows(IllegalArgumentException.class ,()-> wordCounterService.addWords(""));
        Assertions.assertEquals(ex.getMessage(),"An Empty value cannot be added to the wordCounter");
    }

    @Test
    @Order(2)
    public void addWordsTest(){
        Assertions.assertEquals(wordCounterService.addWords("Depte,Mena,Deya,124Depte,Uday").stream().count(),4);
    }

    @Test
    @Order(3)
    public void countWordsTest(){
        List<String> wordList = Arrays.asList("Depte","Mena","Uday","Deya","Depte","Uday");
        ReflectionTestUtils.setField(wordCounterService,"wordList",wordList,List.class);
        Assertions.assertEquals(wordCounterService.wordCount("Depte"),2);
    }
}
