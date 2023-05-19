package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class WordCounterServiceImpl implements WordCounterService{

    List<String> wordList = new ArrayList<>();

    public List<String> addWords(String words) {
        if (words == "") {
            throw new IllegalArgumentException("An Empty value cannot be added to the wordCounter");
        }
        String[] strArr = words.split(",");
        wordList = Arrays.asList(strArr).stream().filter(str -> str.chars().allMatch(Character::isLetter)).collect(Collectors.toList());
        return wordList;
    }

    public Long wordCount(String word) {
        if (word == "") {
            throw new IllegalArgumentException("Please provide the valid word to count");
        }
        Map<String, Long> mapOfWordCount = wordList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<String, Long> map1 : mapOfWordCount.entrySet()) {
            if (map1.getKey().equals(word)) {
                return map1.getValue();
            }
        }
        return null;
    }
}
