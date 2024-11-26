package com.example.OBS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OBS.entity.Buy;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long>{

}
