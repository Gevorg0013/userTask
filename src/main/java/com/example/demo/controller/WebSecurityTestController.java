/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class WebSecurityTestController {
    @GetMapping("/hello")
    public String hello() {
        return "<h2> Hello </h2>";
    }
    
     @GetMapping("/user")
    public String user() {
        return "<h2> Hello user</h2>";
    }
    
     @GetMapping("/admin")
    public String admin() {
        return "<h2> Hello admin</h2>";
    }
}
