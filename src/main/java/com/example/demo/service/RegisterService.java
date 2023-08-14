/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.util.TokenGenerator;
import java.util.Optional;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
@Slf4j
public class RegisterService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> registerAccount(Account registerRequest) throws Exception {
        Optional<Account> existingAccount = accountRepository.findByEmail(registerRequest.getEmail());
        TokenGenerator generateTokenObj = new TokenGenerator();
       
        if (!existingAccount.isPresent()) {
            final Account save1 = accountRepository.save(registerRequest);

            return Optional.ofNullable(save1);
        }
        return Optional.empty();
    }
    
      public Optional<Optional<Account>> findByMail(final String email) {
        return Optional.of(this.accountRepository.findByEmail(email));
    }
      
       public Optional<Account> findById(final String id) {
        return (this.accountRepository.findById(id));
    }
       
      
       public Account findByMailAndByPassword(final String email, final String password) {
        Optional<Account> findByEmailAndPassword = this.accountRepository.findByEmailAndPassword(email,password);
        if(findByEmailAndPassword.isPresent()) {
            log.info("user013 = " + findByEmailAndPassword.get());
            return findByEmailAndPassword.get();
        }
           return null;
    }

    public Optional<List<Account>> getAccounts() {
        return Optional.of(this.accountRepository.findAll());
    }
    
    public boolean deleteById(final String id) {
        if(id!=null) {
         accountRepository.deleteById(id); 
         return true;
        }
        return false;
    }
}
