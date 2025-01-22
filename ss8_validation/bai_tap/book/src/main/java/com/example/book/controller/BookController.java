package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.entity.CodeBook;
import com.example.book.service.IBookService;
import com.example.book.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICodeBookService codeBookService;

    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 3)Pageable pageable) {
        return new ModelAndView("list", "book", bookService.findAll(pageable));
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("book",bookService.findById(id));
        return "/view";
    }



    @PostMapping("/rent")
    public String rent(@ModelAttribute Book book, Model model) throws Exception {
        if (book.getQuantity()>0){
            model.addAttribute("code","book rental code is: " +  codeBookService.saveCodeBook(book));
            book.setQuantity(book.getQuantity()-1);
            bookService.save(book);
            return "/view";
        }else {
            throw new Exception();
        }
    }

    @GetMapping("/giveBack")
    public String giveBack(Long codeBook, RedirectAttributes redirectAttributes){
        CodeBook codeBook1=codeBookService.findByCodeBook(codeBook);
        if (codeBook1 !=null){
            codeBookService.delete(codeBook);
            bookService.giveBack(codeBook1.getBook().getId());
            redirectAttributes.addFlashAttribute("mess","returned the book");
        }else {
            redirectAttributes.addFlashAttribute("mess","not found");
        }
        return "redirect:/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String error(){
        return "/404";
    }
}
