package ee.bcs.valiit.booksearch.crawler;

import ee.bcs.valiit.booksearch.BookData;
import ee.bcs.valiit.booksearch.repository.BookRepository;
import ee.bcs.valiit.booksearch.service.BookService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CrawlerApollo {

    private BookRepository bookRepository;

    public CrawlerApollo(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void bookScrapingResultApollo() {
        int storeId = 1;

        //1. Selle Crawleri teen eraldi meetodiks, et tagastaks listi
        String url = "https://www.apollo.ee/raamatud/eestikeelsed-raamatud?";
        //String url = "https://www.apollo.ee/edetabel/raamatute-topid/eestikeelsete-raamatute-nadala-top-10?";
        List<BookData> bookDataList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            String newUrl = url + "p=" + i;
            String contents = WebReader.readWeb(newUrl);
            Document document = Jsoup.parse(contents);

            Elements elements = document.select("div.products-grid .item");
//            System.out.println(elements.size());
            for (Element e : elements) {
                BookData bookData = new BookData();
                Elements productName = e.getElementsByClass("product-name");
                String bookTitle = productName.get(0).getElementsByTag("a").get(0).attributes().get("title");
                bookData.setBookTitle(bookTitle);
                String author = e.getElementsByClass("author").text();
                bookData.setAuthor(author);
                String price = e.getElementsByClass("regular-price").text();
                //String priceToDouble = price.(0, price.length()-2);
                bookData.setPrice(price);
                String urlPage = productName.get(0).getElementsByTag("a").get(0).attributes().get("href");
                bookData.setUrlPage(urlPage);
                //int storeId = 1;
                bookData.setStoreId(storeId);
                Elements productImage = e.getElementsByClass("image-wrapper");
                String urlImage = productImage.get(0).getElementsByTag("img").get(0).attributes().get("src");
                bookData.setUrlImage(urlImage);
                int index = urlImage.lastIndexOf("/");
                String isbn = urlImage.substring(index + 1, urlImage.length() - 4);
                index = isbn.indexOf("_");
                if (index >= 0){
                    isbn = isbn.substring(0, index);
                }
                else isbn=urlImage.substring(urlImage.lastIndexOf("/")+1, urlImage.length()-4);
                //System.out.println(isbn);
                bookData.setIsbn(isbn);
                bookDataList.add(bookData);
            }

        }

        // kui tahame teist korda crawleri tööle panna, siis tuleb esmalt tabel tühjendada:

        bookRepository.deleteBooks(storeId);

        for (BookData bookData : bookDataList) {

            //select ja update repos kui tahame asendada/uuendada raamtute andmeid,
            // siis ei kasuta deleteApolloBooks meetodit (double hinna lahtrisse)

            bookRepository.saveBooks(bookData);
        }

    }

}
