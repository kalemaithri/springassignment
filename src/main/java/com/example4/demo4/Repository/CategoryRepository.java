package com.example4.demo4.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example4.demo4.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
        Optional<Category> findByIdcat(int id);
    
}
