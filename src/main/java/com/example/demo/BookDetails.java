/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;
import lombok.Data;

/**
 *
 * @author user
 */
@Data
public class BookDetails {

    public BookDetails() {
    }

    public BookDetails(final BookDetailsReponse response) {
        this.id = null;
        this.title = response.getTitle();
        this.author = response.getAuthor();
        this.genre = response.getGenre();
        this.description = response.getDescription();
    }
    private Integer id;
    private String title;
    private String author;
    private String genre;
    private String description;
}
