package ee.bcs.valiit.booksearch.service;

import ee.bcs.valiit.booksearch.BookData;
import ee.bcs.valiit.booksearch.BookDataRowMapper;
import ee.bcs.valiit.booksearch.crawler.*;
import ee.bcs.valiit.booksearch.exception.BookApplicationException;
import ee.bcs.valiit.booksearch.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CrawlerApollo crawlerApollo;

    @Autowired
    private CrawlerApollo2 crawlerApollo2;

    @Autowired
    private CrawlerKriso crawlerKriso;

    @Autowired
    private CrawlerKriso2 crawlerKriso2;

    @Autowired
    private CrawlerKrisoEng crawlerKrisoEng;

    @Autowired
    private CrawlerRaamatukoi crawlerRaamatukoi;

    @Autowired
    private CrawlerRaamatukoi2 crawlerRaamatukoi2;

    //raamatukoi

    public List<BookData> getListOfBooks(String input) {
        if (input.length() < 3) {
            throw new BookApplicationException("Liiga lühike sisend");
        }
        //input peaks olema min 3 tähte !!täiustada
        //try-catch block'i ei ole vaja kasutada listi puhul (tühi object viib errorisse)
        return bookRepository.getListOfBooks(input);
    }

    public void connectToApolloCrawler() {
        crawlerApollo.bookScrapingResultApollo();
    }

    public void connectToApolloCrawler2() {
        crawlerApollo2.bookScrapingResultApollo2();
    }

//    public void connectToKrisoCrawler() {
//        crawlerKriso.bookScrapingResultKriso();
//    }

    public void connectToKrisoCrawler2() {
        crawlerKriso2.bookScrapingResultKriso2();
    }

    public void connectToKrisoCrawlerEng() {
        crawlerKrisoEng.bookScrapingResultKrisoEng();
    }

    public void connectToRaamatukoiCrawler() {
        crawlerRaamatukoi.bookScrapingResultRaamatukoi();
    }

    public void connectToRaamatukoiCrawler2() {
        crawlerRaamatukoi2.bookScrapingResultRaamatukoi2();
    }


}
