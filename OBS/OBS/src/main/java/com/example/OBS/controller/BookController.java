package com.example.OBS.controller;

import com.example.OBS.entity.Book;
import com.example.OBS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "user_index";
    }
    
//    @GetMapping("/books/buy/{id}")
//    public String showBuyForm(@PathVariable Long id, Model model) {
//        Book book = bookService.getBookById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
//        model.addAttribute("book", book);
//        return "buy";
//    }
//    
//    @PostMapping("/books/buy")
//    public String buyBook(@ModelAttribute Book book) {
//        bookService.saveBook(book);
//        return "redirect:/";
//    }
    
    @GetMapping("/admin-login")
    public String adminLogin() {
    	return "login";
    }
    
    @PostMapping("/admin/login")
    public String loginAdmin(@RequestParam String username, @RequestParam String password, Model model) {
        String mapping = ""; // Default redirect if login fails
        if ("admin".equals(username) && "admin@123".equals(password)) { // Use equals() for string comparison
        	List<Book> books = bookService.getAllBooks();
            model.addAttribute("books", books);
            mapping = "index"; // Redirect to the admin dashboard
        } else {
            mapping = "login";
        }
        return mapping;
    }
    
    @GetMapping("/admin")
    public String admin(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/books/new")
    public String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "new_book";
    }

    @PostMapping("/books/save")
    public String saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/admin";
    }
    
    @PostMapping("/books/save1/{id}")
    public String updateBook(@PathVariable Long id,@ModelAttribute Book book) {
    	bookService.deleteBook(id);
        bookService.saveBook(book);
        return "redirect:/admin";
    }

    @GetMapping("/books/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/admin";
    }

    @GetMapping("/books/search")
    public String searchBooks(@RequestParam String keyword, Model model) {
        List<Book> searchResults = bookService.searchBooks(keyword);
        model.addAttribute("books", searchResults);
        return "index";
    }

    @GetMapping("/books/category/{category}")
    public String getBooksByCategory(@PathVariable String category, Model model) {
        List<Book> books = bookService.getBooksByCategory(category);
        model.addAttribute("books", books);
        return "index";
    }
}