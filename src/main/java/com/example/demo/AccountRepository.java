/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.util.List;
import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Transactional
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByEmailAndPassword(String email, String password);

    Optional<Account> findByEmail(String email);
    
    @Override
    List<Account> findAll();
    

}