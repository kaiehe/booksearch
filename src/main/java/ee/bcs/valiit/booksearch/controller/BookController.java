package ee.bcs.valiit.booksearch.controller;

import ee.bcs.valiit.booksearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //3 meetodit mille järgi frondist otsime: isbn, autor, pealkiri

    public String searchByAuthor(){
        return null;
    }

}
