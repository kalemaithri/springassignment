package com.example4.demo4.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example4.demo4.model.registerModel;

public interface registersRepository extends JpaRepository<registerModel,Integer>{
    Optional<registerModel>  findByEmailAndPassword(String email, String password);

    Optional<registerModel> findFirstByEmail(String Email);
}
