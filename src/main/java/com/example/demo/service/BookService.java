/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class BookService {
    @Autowired
    private BookClient bookClient;
    @Autowired
    private BookRepo bookRepo;
    
     public void generate() {

//        boolean added = false;
//        int triesCount = 0;
//        do {
//            ++triesCount;
//            final Optional<BookDetails> details = this.bookClient.getBooks();
//            if (details.isEmpty()) {
//                continue;
//            }
//            if (bookRepo.countByJokeId(details.get().getId()) != 0) {
//                continue;
//            }
//            final JokeDetails newJoke = new JokeDetails(details.get());
//            newJoke.setCreateTime(ZonedDateTime.now().toEpochSecond());
//            this.jokeRepo.save(newJoke);
//            added = true;
//        } while (!added && triesCount != 100);
    }
    
}
