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
        bookService.connectToKrisoCrawler();
        bookService.connectToKrisoCrawler2();
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void sendApolloToDatabase() {
        bookService.connectToApolloCrawler();
        bookService.connectToApolloCrawler2();
    }


    //    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
//    public void sendAllBooksToDatabase2() {
//        crawlerRaamatukoi2.bookScrapingResultRaamatukoi2();
//        crawlerApollo.bookScrapingResultApollo();
//        crawlerKriso.bookScrapingResultKriso();
//
//    }

}
