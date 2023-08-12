package com.example.demo.service;

import com.example.demo.model.BookDetails;
import io.vavr.control.Try;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author user
 */
@Service
@Slf4j
public class BookClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BOOK_API = "https://fakerapi.it/api/v1/books?";

    public BookDetails getBooks() throws Exception {

        final Try<BookDetails> response = Try.of(()
                -> this.restTemplate.getForObject(BOOK_API, BookDetails.class));

        if (!response.isSuccess()) {
            System.err.println("Couldn't get joke details!");
            return null;
        }
        log.info("reponse013: " + response.get());
        return response.get();
    }
}
