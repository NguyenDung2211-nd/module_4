package com.example.dictionary.repository;

import com.example.dictionary.entity.Word;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository {
    private static List<Word> words = new ArrayList<>();

    static {
        words.add(new Word("Hello","Xin chào"));
        words.add(new Word("Goodbye","tạm biệt"));
        words.add(new Word("Book","Quyển sách"));
        words.add(new Word("Computer","Máy tính"));
    }

    public Word findByEnglish(String english){
        for(Word word : words){
            if(word.getEnglish().equalsIgnoreCase(english)){
                return word;
            }
        }
        return null;
    }
}
