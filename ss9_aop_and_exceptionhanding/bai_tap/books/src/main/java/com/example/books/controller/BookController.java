package com.example.books.controller;

import com.example.books.entity.Book;
import com.example.books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public ModelAndView listBook(Model model) {
        return new ModelAndView("manager/list", "books", bookService.getAll());
    }

    @GetMapping("/show-add")
    public String showAdd(Model model) {
        model.addAttribute("book", new Book());
        return "manager/add";
    }

    @PostMapping("/add")
    public String addBook(@Validated @ModelAttribute("book") Book book,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors());
            return "manager/add";
        }

            bookService.addBook(book);
        redirectAttributes.addFlashAttribute("message", "Thêm sách thành công");
        return "redirect:/home";
    }

    @GetMapping("/{id}")
    public String detailBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "manager/detail";
    }

    @GetMapping("/{id}/show_confirm")
    public String showConfirmBorrow(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "borrow/confirm";
    }

    @GetMapping("/{id}/show-return")
    public String showConfirmReturn(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "borrow/confirm-return";
    }

    @PostMapping("/{id}/borrow")
    public String borrowBook(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        int borrowCode = bookService.borrowBook(id);
        redirectAttributes.addFlashAttribute("message", "Mượn sách thành công! Mã mượn: " + borrowCode);
        return "redirect:/home";
    }

    @PostMapping("/{id}/return")
    public String returnBook(@PathVariable("id") int id, @RequestParam("code") int code, RedirectAttributes redirectAttributes) {
        boolean isReturned = bookService.returnBook(id, code);
        if (isReturned) {
            redirectAttributes.addFlashAttribute("message", "Sách được trả lại thành công!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Không trả lại sách.");
        }

        return "redirect:/home";
    }
}