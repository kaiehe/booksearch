package ee.bcs.valiit.booksearch.service;

import ee.bcs.valiit.booksearch.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

}
