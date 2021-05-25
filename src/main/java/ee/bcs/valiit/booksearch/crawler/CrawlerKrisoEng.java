package ee.bcs.valiit.booksearch.crawler;

import ee.bcs.valiit.booksearch.BookData;
import ee.bcs.valiit.booksearch.repository.BookRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CrawlerKrisoEng {

    private BookRepository bookRepository;

    public CrawlerKrisoEng(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public static void main(String[] args) {
//        CrawlerKriso crawler = new CrawlerKriso();
//        crawler.bookScrapingResultKriso();
    }

    public void bookScrapingResultKrisoEng() {
        int storeId = 3;
        String contents = WebReader.readWeb("https://www.kriso.ee/cgi-bin/shop/searchbooks.html?database=english2&lim=1000&type=instock");
        Document documentKriso = Jsoup.parse(contents);

        List<BookData> bookDataList = new ArrayList<>();

        Elements elements = documentKriso.select("ul.book-list.clearfix .list-item");
        for (Element e : elements) {
            BookData bookData = new BookData();
            Elements productName = e.getElementsByClass("book-desc-wrap");
            String bookTitle = productName.get(0).getElementsByTag("a").get(0).attributes().get("title");
            bookData.setBookTitle(bookTitle);
            String author = e.getElementsByClass("book-author").text();
            bookData.setAuthor(author);
            String price = e.getElementsByClass("book-price").text();
            price = price.substring(6, price.length() - 2);
            bookData.setPrice(price);
            String urlPage = productName.get(0).getElementsByTag("a").get(0).attributes().get("href");
            bookData.setUrlPage(urlPage);
            Elements findIsbn = e.getElementsByClass("book-img-overlay");
            String isbn = findIsbn.get(0).getElementsByTag("a").get(0).attributes().get("data-sku");
            bookData.setIsbn(isbn);
            //storeId on hardcode'itud üleval
            bookData.setStoreId(storeId);
            String bookFeatures = e.getElementsByClass("book-features").text();
            String yearofPublishing = bookFeatures.substring(13);
            String year = yearofPublishing.substring(0,11);
            if (!year.contains(",")) {
                bookData.setYearOfPublishing(year);
            } else {
                continue;
            }
//            String bookTypeInitial = bookFeatures.substring(19);
//            String format = bookTypeInitial.substring(0,11);
//            bookData.setFormat(format);
            Elements productImage = e.getElementsByClass("book-img-link");
            String imgLink = productImage.get(0).getElementsByTag("img").get(0).attributes().get("data-original");
            String imgUrl = "https://d33318exxque5k.cloudfront.net/" + imgLink;
            bookData.setUrlImage(imgUrl);
            bookDataList.add(bookData);
        }

        bookRepository.deleteBooks(storeId);

        for(BookData bookData: bookDataList){
            bookRepository.saveBooks(bookData);
        }
    }

}
