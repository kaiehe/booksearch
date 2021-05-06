package ee.bcs.valiit.booksearch.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerKriso {

    public static void main(String[] args) {
        String contents = WebReader.readWeb("https://www.kriso.ee/cgi-bin/shop/searchbooks.html?database=estonian2&type=instock");

        Document documentKriso = Jsoup.parse(contents);

        Elements elements = documentKriso.select("ul.book-list.clearfix .list-item");
        System.out.println(elements.size());
        for (Element e : elements) {
            Elements productName = e.getElementsByClass("book-desc-wrap");
            String title = productName.get(0).getElementsByTag("a").get(0).attributes().get("title");
            String author = e.getElementsByClass("book-author").text();
            String productPrice = e.getElementsByClass("book-price").text();
            productPrice = productPrice.substring(7, productPrice.length() - 2);
            String link = productName.get(0).getElementsByTag("a").get(0).attributes().get("href");
            Elements findIsbn = e.getElementsByClass("book-img-overlay");
            String isbn = findIsbn.get(0).getElementsByTag("a").get(0).attributes().get("data-sku");
            //String ISBN  =
//            Elements productImage = e.getElementsByClass("book-img-link");
//            String imgLink = productImage.get(0).getElementsByTag("img").get(0).attributes().get("src");
//            System.out.println(imgLink);
            System.out.println(title + " " + author + " " + isbn + " " + productPrice + " " + link);
        }
    }
}
