package com.example.dictionary.controller;

import com.example.dictionary.entity.Word;
import com.example.dictionary.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/translate")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("")
    public String index() {
        return "dictionary";
    }

    @PostMapping("")
    public String translate(@RequestParam("word") String word, Model model) {
        if (word.matches(".*\\d.*")) {
            model.addAttribute("word", word);
            model.addAttribute("result", "Từ cần tra không được chứa số. Hãy nhập lại.");
        } else {
            Word result = dictionaryService.translate(word);
            if (result != null) {
                model.addAttribute("word", word);
                model.addAttribute("result", result.getVietnamese());
            } else {
                model.addAttribute("word", word);
                model.addAttribute("result", "Không tìm thấy.");
            }
        }
        return "dictionary";
    }
}
