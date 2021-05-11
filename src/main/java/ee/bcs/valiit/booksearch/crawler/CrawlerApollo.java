package ee.bcs.valiit.booksearch.crawler;

import ee.bcs.valiit.booksearch.BookData;
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

    @Autowired
    public BookService bookService;

    public static void main(String[] args) {
//        CrawlerApollo crawler = new CrawlerApollo();
//        crawler.bookScrapingResultApollo();

//        String a = "20,95 €";
//        System.out.println(a.substring(0, a.length()-2).replace(",","."));
    }

    public void bookScrapingResultApollo() {

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
                int storeId = 1;
                bookData.setStoreId(storeId);
                Elements productImage = e.getElementsByClass("image-wrapper");
                String urlImage = productImage.get(0).getElementsByTag("img").get(0).attributes().get("src");
                bookData.setUrlImage(urlImage);
                System.out.println(bookTitle + " " + " " + author + " " + price + " " + urlPage);
                bookDataList.add(bookData);
            }
        }
//        for (BookData bookData : bookDataList) {
//            System.out.println(bookData);
//        }
        //   return bookDataList;
        //bookService.sendApolloBooks(bookDataList);
    }

    public void bookData(List<BookData> bookDataList) {
        bookService.sendApolloBooks(bookDataList);
    }

}
