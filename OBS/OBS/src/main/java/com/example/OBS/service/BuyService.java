package com.example.OBS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OBS.entity.Book;
import com.example.OBS.entity.Buy;
import com.example.OBS.repository.BuyRepository;

@Service
public class BuyService {
	@Autowired
    private BuyRepository buyRepository;
	
	public Buy saveBuy(Buy buy) {
        return buyRepository.save(buy);
    }
	
	 public List<Buy> getAllBuys() {
	     return buyRepository.findAll();
	 }

	public void deleteBuy(Long id) {
		// TODO Auto-generated method stub
		buyRepository.deleteById(id);
	}

	public Optional<Buy> getBuyById(Long id) {
		// TODO Auto-generated method stub
		return buyRepository.findById(id);
	}
}
