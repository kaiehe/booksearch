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

        String sql="SELECT * FROM books b FULL OUTER JOIN store s ON b.store_id=s.id WHERE UPPER(book_title) " +
                "LIKE UPPER(:dbInput) OR UPPER(author) LIKE UPPER(:dbInput) OR isbn LIKE :dbInput";
        Map<String, Object> paramMap=new HashMap<>();
        paramMap.put("dbInput", "%"+input+"%");
        return jdbcTemplate.query(sql,paramMap, new BookDataRowMapper());

    }


}
