package com.example4.demo4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example4.demo4.model.Expense;


public interface ExpenseRepository  extends JpaRepository<Expense,Integer>{
    
}
