package ee.bcs.valiit.booksearch.repository;

import ee.bcs.valiit.booksearch.BookData;
import ee.bcs.valiit.booksearch.BookDataRowMapper;
import ee.bcs.valiit.booksearch.controller.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public List<BookData> getListOfBooks(String input) {

        String sql="SELECT * FROM books b JOIN store s ON b.store_id=s.id WHERE UPPER(book_title) " +
                "LIKE UPPER(:dbInput) OR UPPER(author) LIKE UPPER(:dbInput) OR isbn LIKE :dbInput";
        Map<String, Object> paramMap=new HashMap<>();
        paramMap.put("dbInput", "%"+input+"%");
        return jdbcTemplate.query(sql,paramMap, new BookDataRowMapper());

    }


    public void saveApolloBooks(BookData bookData) {
        String sql = "INSERT INTO books(book_title, author, isbn, year_of_publishing, number_of_pages, format, price, " +
                "store_id, url_image, url_data) VALUES(:dbBookTitle, :dbAuthor, :dbIsbn, :dbYearOfPublishing, :dbNumberOfPages, :dbFormat," +
                ":dbPrice, :dbStoreId, :dbUrlImage, :dbUrlData)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbBookTitle", bookData.getBookTitle());
        paramMap.put("dbAuthor", bookData.getAuthor());
        paramMap.put("dbIsbn", bookData.getIsbn());
        paramMap.put("dbYearOfPublishing", bookData.getYearOfPublishing());
        paramMap.put("dbNumberOfPages", bookData.getNumberOfPages());
        paramMap.put("dbFormat", bookData.getFormat());
        paramMap.put("dbPrice", bookData.getStoreId());
        paramMap.put("dbFormat", bookData.getPrice());
        paramMap.put("dbUrlImage", bookData.getUrlImage());
        paramMap.put("dbUrlData", bookData.getUrlPage());
        jdbcTemplate.update(sql,paramMap);

        //hardcode'ime Liquibase'i teise tabli sisse

    }
}
