/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author user
 */
public class RegisterService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> registerAccount(Account registerRequest) throws Exception {
        Optional<Account> existingAccount = accountRepository.findByEmail(registerRequest.getEmail());

        if (!existingAccount.isPresent()) {
            final Account save1 = accountRepository.save(registerRequest);

            return Optional.ofNullable(save1);
        }
        return Optional.empty();
    }
    
      public Optional<Optional<Account>> findByMail(final String email) {
        return Optional.of(this.accountRepository.findByEmail(email));
    }

    public Optional<List<Account>> getAccounts() {
        return Optional.of(this.accountRepository.findAll());
    }
    
    public String deleteById(final String id) {
        if(id!=null) {
         accountRepository.deleteById(id); return "Usel deleted";
        }
        return "id is missed";
    }
}
