package ee.bcs.valiit.booksearch.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerApollo {
    public static void main(String[] args) {
        String contents = WebReader.readWeb("https://www.apollo.ee/raamatud/eestikeelsed-raamatud/uued-eesti-keeles");

        Document document = Jsoup.parse(contents);
        Elements elements = document.select("div.products-grid .item");
        System.out.println(elements.size());
        for (Element e : elements) {
            Elements productName = e.getElementsByClass("product-name");
            String title = productName.get(0).getElementsByTag("a").get(0).attributes().get("title");
            String link = productName.get(0).getElementsByTag("a").get(0).attributes().get("href");
            String productPrice = e.getElementsByClass("regular-price").text();
            String author = e.getElementsByClass("author").text();
            System.out.println(title + " " + " " + author + " " + productPrice + " " + link);
        }
    }
}
