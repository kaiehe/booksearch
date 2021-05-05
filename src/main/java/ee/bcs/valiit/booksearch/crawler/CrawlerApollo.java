package ee.bcs.valiit.booksearch.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerApollo {
    public static void main(String[] args) {
        String contents = WebReader.readWeb("https://www.apollo.ee/raamatud/eestikeelsed-raamatud/uued-eesti-keeles");
        //System.out.println(contents2);

        Document document = Jsoup.parse(contents);
       // System.out.println(document);
        Elements elements = document.select("div.products-grid.item");
        System.out.println(elements.size());
        for (Element e : elements) {
            //System.out.println(e.attributes().get("href"));
            //System.out.println(e.text());
            Elements productName = e.getElementsByClass("product-name");
            String title = productName.get(0).getElementsByTag("a").get(0).attributes().get("title");
            System.out.println(title);
        }
    }
}
