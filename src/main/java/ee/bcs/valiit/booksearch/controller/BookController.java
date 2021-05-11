package ee.bcs.valiit.booksearch.controller;

import ee.bcs.valiit.booksearch.BookData;
import ee.bcs.valiit.booksearch.crawler.CrawlerApollo;
import ee.bcs.valiit.booksearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
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

    //1 meetod mille järgi frondist otsime (laseme sisestada Stringi [isbn, autor, pealkiri])

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


}
