package com.example.TH_Java_Buoi3.controller;


import com.example.TH_Java_Buoi3.entity.Book;
import com.example.TH_Java_Buoi3.services.BookService;
import com.example.TH_Java_Buoi3.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")

public class BookController {
    @Autowired
    private final BookService bookService;

    @Autowired
    private final CategoryService categoryService;


    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/")
    public String home(){ return "home/index";}

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book",new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("categories",categoryService.getAllCategories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "/book/edit";
    }

//test
@PostMapping("/edit/{id}")
public String updateBook(@PathVariable("id") Long id, @Valid Book book,
                             BindingResult result) {
    if (result.hasErrors()) {
        book.setId(id);
        return "/book/edit";
    }
    bookService.updateBook(book);
    /*model.addAttribute("categories", categoryService.getAllCategories());*/
    return "redirect:/books";
}
}
