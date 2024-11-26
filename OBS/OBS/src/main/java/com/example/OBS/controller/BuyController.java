package com.example.OBS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.OBS.entity.Book;
import com.example.OBS.entity.Buy;
import com.example.OBS.service.BookService;
import com.example.OBS.service.BuyService;

@Controller
public class BuyController {
	@Autowired
    private BuyService buyService;
	
	@Autowired
    private BookService bookService;
	
	@GetMapping("/books/buy/{id}")
    public String showBuyForm(@PathVariable Long id, Model model) {
		Book book = bookService.getBookById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		Buy buy=new Buy();
		buy.setTitle(book.getTitle());
		buy.setPrice(book.getPrice());
		buy.setQuantity(book.getQuantity());
		buy.setAddress("");
		buy.setEmail("");
		buy.setName("");
		model.addAttribute("buy", buy);
        return "buy";
    }
	
	@GetMapping("/admin/buy")
    public String showBuyList(Model model) {
        List<Buy> buy = buyService.getAllBuys();
        model.addAttribute("buy", buy);
        return "buy_list";
    }
	
    @PostMapping("/books/buy")
    public String buyBook(@ModelAttribute Buy buy) {
        buyService.saveBuy(buy);
        return "redirect:/";
    }
    
    @GetMapping("/admin/buy/delete/{id}")
    public String deleteBuy(@PathVariable Long id) {
        buyService.deleteBuy(id);
        return "redirect:/admin/buy";
    }
    
    @GetMapping("/admin/buy/update/{id}")
    public String showBuyUpdateForm(@PathVariable Long id, Model model) {
        Buy buy = buyService.getBuyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("buy", buy);
        return "update_buy";
    }
    
    @PostMapping("/admin/buy/update/{id}")
    public String updateBuy(@PathVariable Long id,@ModelAttribute Buy buy) {
    	buyService.deleteBuy(id);
        buyService.saveBuy(buy);
        return "redirect:/admin/buy";
    }
    
}
