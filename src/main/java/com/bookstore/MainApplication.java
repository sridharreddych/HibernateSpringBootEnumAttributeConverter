package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.persistNewAuthor();
            bookstoreService.fetchAuthor();
        };
    }
}
/*
 * 
 * How To Map Java enum To Database Via AttributeConverter

Description: This application maps a Java enum via AttributeConverter. In other words, it maps the enum values HORROR, ANTHOLOGY and HISTORY to the integers 10, 20 and 30 and viceversa. This allows us to set the column type as TINYINT/SMALLINT which is less space-consuming than VARCHAR(9) needed in this case.

Key points:

define a custom AttributeConverter
annotate with @Converter the corresponding entity field
 */
