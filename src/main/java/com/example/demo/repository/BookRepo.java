/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

/**
 *
 * @author user
 */
import com.example.demo.model.BookDetails;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<BookDetails, String> {

//    public List<BookDetails> findByTypeOrderByCreateTimeDesc(final String type);
//
//    public List<BookDetails> findByPunchlineLikeOrSetupLikeOrderByCreateTimeDesc(final String puchline, final String setup);
//
//    public List<BookDetails> findBySetupOrPunchlineOrderByCreateTimeDesc(final String punchline, final String setup);
//
//    public long countByBookId(final long jokeId);
//
//    public List<BookDetails> findByType(String type);
//
//    public List<BookDetails> findByPunchlineLikeOrSetupLike(String pattern, String pattern0);
//
//    public List<BookDetails> findBySetupOrPunchline(String key, String key0);
}