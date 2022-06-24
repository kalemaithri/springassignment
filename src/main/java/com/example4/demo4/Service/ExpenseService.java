package com.example4.demo4.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example4.demo4.model.Expense;
import com.example4.demo4.Repository.CategoryRepository;
import com.example4.demo4.Repository.ExpenseRepository;
@Service
public class ExpenseService {
    
    private ExpenseRepository expenseRepository;
    public ExpenseService (ExpenseRepository expenseRepository,CategoryRepository categoryRepository){
        this.expenseRepository=expenseRepository;}
    public Expense addexpense(Integer expense_id,String date ,String description,String location, Integer id){
        Expense expense =new Expense();
        if (expense_id==null || id == null){

            return null;
        }
        else{
            
            expense.setExpense_id(expense_id);
            expense.setDate(date);
            expense.setDescription(description);
            expense.setLocation(location);
            expense.setCategoryid(id);
         
           }
        return expenseRepository.save(expense);
    }
    public List<Expense> allexpenses(){
        return expenseRepository.findAll();
    }

}
