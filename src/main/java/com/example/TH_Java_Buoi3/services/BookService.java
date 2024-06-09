package com.example.TH_Java_Buoi3.services;

import com.example.TH_Java_Buoi3.entity.Book;
import com.example.TH_Java_Buoi3.repository.IBookRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(@NotNull Book book){
        if (book == null || book.getId() == null) {
            throw new IllegalArgumentException("Invalid book object");
        }

        Book existingBook = getBookById(book.getId());


        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setCategory(book.getCategory());


         bookRepository.save(existingBook);
    }


}
