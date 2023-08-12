  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

/**
 *
 * @author user
 */
import com.example.demo.service.BookClient;
import com.example.demo.model.BookDetails;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private BookClient bookClient;
    @Autowired
    private UserRepository userRepo;

    // Save method is predefine method in Mongo Repository
    // with this method we will save user in our database
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    // findAll method is predefine method in Mongo Repository
    // with this method we will all user that is save in our database
    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    //delete all user
    @DeleteMapping("/deleteAllData")
    public void deleteAll() {
        userRepo.deleteAll();
    }

    @GetMapping("getBooks")
    public BookDetails getBooks() throws Exception {
        BookDetails books = bookClient.getBooks();
        if (books == null) {
            log.info("empty013");
            return null;
        } else {
            log.info(" non empty013" + books);
            return books;
        }
    }

    //if user is super admin he can add admin
    @PutMapping("/add_admin_by_supperAdmin")
    public ResponseEntity addAdminBySuperAdmin(
            @RequestParam final long currentUserId,
            @RequestParam final String role,
            @RequestParam final long id
    ) throws Exception {
        Optional<User> userId = userRepo.findById(currentUserId);  //user ho wants to change role
        if(userId.isPresent() && userId.get().getRole().equals("Super Admin")) {
        Optional<User> findById = userRepo.findById(id);
        if (findById.isPresent()) {
            findById.get().setRole(role);
            User save = userRepo.save(findById.get());
            return ResponseEntity.ok(save);
        }
        }
        return ResponseEntity.badRequest().body("userId is invalid!");
    }

    @GetMapping("/manageBooksAndUser_byAdmin")
    public ResponseEntity getBooksAndUsers(
    ) throws Exception {
        List<User> user = userRepo.findAll();
        BookDetails books = bookClient.getBooks();  
        //here we can do some operaions with users;
        return ResponseEntity.ok("ok");
    }
    
    @GetMapping("/getBooksByUser")
    public ResponseEntity getBooksByUserRole(
    @RequestParam final long userId
    ) throws Exception {
        Optional<User> findById = userRepo.findById(userId);
        if(findById.isPresent() && findById.get().getRole().equals("USER")) {
            BookDetails books = bookClient.getBooks();
            return ResponseEntity.ok(books);
        }
        return ResponseEntity.badRequest().body("can't find any book");
        
    }
}
