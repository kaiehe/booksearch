package ee.bcs.valiit.booksearch;

import ee.bcs.valiit.booksearch.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BookScheduler {

    private BookService bookService;

    public BookScheduler(BookService bookService) {
        this.bookService = bookService;
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void sendRaamatukoiBooks() {
        System.out.println("Started raamatukoi crawler");
        bookService.connectToRaamatukoiCrawler();
        System.out.println("Started raamatukoi second crawler");
        bookService.connectToRaamatukoiCrawler2();
        System.out.println("Finished raamatukoi crawler");
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void sendKrisoBooks() {
        System.out.println("Started kriso crawler");
        bookService.connectToKrisoCrawler();
        System.out.println("Started kriso second crawler");
        bookService.connectToKrisoCrawler2();
        System.out.println("Finished kriso crawler");
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void sendApolloToDatabase() {
        System.out.println("Started apollo crawler");
        bookService.connectToApolloCrawler();
        System.out.println("Started apollo second crawler");
        bookService.connectToApolloCrawler2();
        System.out.println("Finished apollo crawler");
    }


    //    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
//    public void sendAllBooksToDatabase2() {
//        crawlerRaamatukoi2.bookScrapingResultRaamatukoi2();
//        crawlerApollo.bookScrapingResultApollo();
//        crawlerKriso.bookScrapingResultKriso();
//
//    }

}
