package com.example.OBS.service;

import com.example.OBS.entity.Book;
import com.example.OBS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Book> getBooksByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
}