package ee.bcs.valiit.booksearch.controller;

import ee.bcs.valiit.booksearch.BookData;
import ee.bcs.valiit.booksearch.crawler.*;
import ee.bcs.valiit.booksearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RequestMapping("api")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //selleks, et teha scheduler on vaja kutsuda crawlerite meetodeid
    // (meie projektis on OK jätta service kiht vahele),
    // autowire'in controlleri crawleritega:

    @Autowired
    private CrawlerApollo crawlerApollo;

    @Autowired
    private CrawlerApollo2 crawlerApollo2;

    @Autowired
    private CrawlerKriso crawlerKriso;

    @Autowired
    private CrawlerKriso2 crawlerKriso2;

    @Autowired
    private CrawlerRaamatukoi crawlerRaamatukoi;

    @Autowired
    private CrawlerRaamatukoi2 crawlerRaamatukoi2;


    @GetMapping("/booksearch/{input}")
    public List<BookData> searchBooks(@PathVariable("input") String input) {
                return bookService.getListOfBooks(input);
    }

    @GetMapping("/sendApolloBooks")
    public void sendApolloToDatabase() {
        bookService.connectToApolloCrawler();
        bookService.connectToApolloCrawler2();
    }

    @GetMapping("/sendKrisoBooks")
    public void sendKrisoBooks() {
        bookService.connectToKrisoCrawler();
        bookService.connectToKrisoCrawler2();
    }


    @GetMapping("/sendRaamatukoiBooks")
    public void sendRaamatukoiBooks() {
        System.out.println("Started raamatukoi crawler");
        bookService.connectToRaamatukoiCrawler();
        System.out.println("Started raamatukoi second crawler");
        bookService.connectToRaamatukoiCrawler2();
        System.out.println("Finished raamatukoi crawler");
    }

//   // @GetMapping("/sendRaamatukoiBooks2")
//   @Scheduled(fixedDelay = 1000 * 60 * 60)
//    public void sendRaamatukoiBooks2() {
//        bookService.connectToRaamatukoiCrawler2();
//    }


    //BooksearchApplicationisse tuleb lisada @EnableScheduling, et ajastamine töötaks

    public void sendAllBooksToDatabase() {
        crawlerRaamatukoi.bookScrapingResultRaamatukoi();
    }



}
