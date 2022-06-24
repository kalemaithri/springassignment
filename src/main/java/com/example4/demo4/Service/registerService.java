package com.example4.demo4.Service;

import org.springframework.stereotype.Service;

import com.example4.demo4.Repository.registersRepository;

import com.example4.demo4.model.registerModel;

@Service
public class registerService {
    private registersRepository regRepository;

    public registerService(registersRepository regRepository) {
        this.regRepository = regRepository;
    }
    public registerModel registerUser(String email, String password, String fname, String lname){
        if(email!=null && password!=null){
            if(regRepository.findFirstByEmail(email).isPresent()){
                System.out.println("duplicate logi");
                return null;
            }
            registerModel regModel =new registerModel();

            regModel.setEmail(email);
            regModel.setPassword(password);
            regModel.setFname(fname);
            regModel.setLname(lname);
            return regRepository.save(regModel);

        
        }
        else{
            return null;
        }
    
    }
    public registerModel authenticate(String email, String password){
        return regRepository.findByEmailAndPassword(email, password).orElse(null);
    }
}
