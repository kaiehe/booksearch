package ee.bcs.valiit.booksearch;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDataRowMapper implements RowMapper<BookData> {

        @Override
        public BookData mapRow(ResultSet resultSet, int i) throws SQLException {
            BookData response= new BookData();
            response.setBookId(resultSet.getInt("book_id"));
            response.setBookTitle(resultSet.getString("book_title"));
            response.setAuthor(resultSet.getString("author"));
            response.setIsbn(resultSet.getString("isbn"));
            response.setYearOfPublishing(resultSet.getString("year_of_publishing"));
            response.setNumberOfPages(resultSet.getString("number_of_pages"));
            response.setFormat(resultSet.getString("format"));
            response.setPrice(resultSet.getDouble("price"));
            response.setStoreName(resultSet.getString("store_name"));
            response.setUrlImage(resultSet.getString("url_image"));
            response.setUrlPage(resultSet.getString("url_data"));

            return response;
        }

}
