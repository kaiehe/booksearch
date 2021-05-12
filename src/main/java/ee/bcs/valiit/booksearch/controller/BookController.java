package ee.bcs.valiit.booksearch.controller;

import ee.bcs.valiit.booksearch.BookData;
import ee.bcs.valiit.booksearch.crawler.CrawlerApollo;
import ee.bcs.valiit.booksearch.crawler.CrawlerKriso;
import ee.bcs.valiit.booksearch.crawler.CrawlerRaamatukoi;
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
    private CrawlerKriso crawlerKriso;

    @Autowired
    private CrawlerRaamatukoi crawlerRaamatukoi;


    @GetMapping("/booksearch/{input}")
    public List<BookData> searchBooks(@PathVariable("input") String input){
        //bookService.findBookId(input);

        return bookService.getListOfBooks(input);
    }

    @GetMapping("/sendApolloBooks")
    public void sendApolloToDatabase(){
        bookService.connectToApolloCrawler();
//        CrawlerApollo apollo=new CrawlerApollo();
//        apollo.bookScrapingResultApollo();
    }

    @GetMapping("/sendKrisoBooks")
    public void sendKrisoBooks(){
        bookService.connectToKrisoCrawler();
    }

    @GetMapping("/sendRaamatukoiBooks")
    public void sendRaamatukoiBooks(){
        bookService.connectToRaamatukoiCrawler();
    }


    @Scheduled(fixedDelay = 1000*60*60*24)
    public void sendAllBooksToDatabase(){
        crawlerApollo.bookScrapingResultApollo();
        crawlerKriso.bookScrapingResultKriso();
        crawlerRaamatukoi.bookScrapingResultRaamatukoi();
    }
}
