package ee.bcs.valiit.booksearch.service;

import ee.bcs.valiit.booksearch.BookData;
import ee.bcs.valiit.booksearch.BookDataRowMapper;
import ee.bcs.valiit.booksearch.crawler.CrawlerApollo;
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

    public List<BookData> getListOfBooks(String input) {
        if(input.length()<3){
            throw new BookApplicationException("Liiga lühike sisend");
        }
        //input peaks olema min 3 tähte !!täiustada
        //try-catch block'i ei ole vaja kasutada listi puhul (tühi object viib errorisse)
        return bookRepository.getListOfBooks(input);
    }

    public void connectToApolloCrawler(){
        crawlerApollo.bookScrapingResultApollo();
    }

//    public void sendApolloBooks(List<BookData> bookDataList) {
//        for (BookData bookData : bookDataList) {
//            bookRepository.saveApolloBooks(bookData);
//            //System.out.println(bookData);
//        }
//    }


    public void sendKrisoBooks(List<BookData> bookDataList) {
        for (BookData bookData:  bookDataList) {
        }
    }
}
