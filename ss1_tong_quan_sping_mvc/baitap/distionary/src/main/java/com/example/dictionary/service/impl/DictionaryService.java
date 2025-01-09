package com.example.dictionary.service.impl;

import com.example.dictionary.entity.Word;
import com.example.dictionary.repository.DictionaryRepository;
import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;

    @Override
    public Word translate(String english) {
        return dictionaryRepository.findByEnglish(english);
    }
}
