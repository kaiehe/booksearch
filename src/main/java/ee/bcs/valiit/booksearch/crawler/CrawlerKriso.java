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
            String link = productName.get(0).getElementsByTag("a").get(0).attributes().get("href");
//            Elements pricing = e.getElementsByClass("book-price");
//            String price = pricing.get(0).getElementsByTag("span").get(0).attributes().get("\"");
//            System.out.println(price);
            String productPrice = e.getElementsByClass("book-price").text();
            productPrice = productPrice.substring(7, productPrice.length() - 2);
            System.out.println(productPrice);

           // System.out.println(title + " " + author + " " + link);
            //String productPrice = e.getElementsByClass("regular-price").text();
        }
    }
}