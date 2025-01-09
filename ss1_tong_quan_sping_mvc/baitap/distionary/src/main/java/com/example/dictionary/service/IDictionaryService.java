package com.example.dictionary.service;

import com.example.dictionary.entity.Word;

public interface IDictionaryService {
    Word translate(String english);
}
