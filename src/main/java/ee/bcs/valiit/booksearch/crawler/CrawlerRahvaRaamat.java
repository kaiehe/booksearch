package ee.bcs.valiit.booksearch.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class CrawlerRahvaRaamat {

    public static void main(String[] args) {

        String contents = WebReader.readWeb("https://www.rahvaraamat.ee/c/raamatud/1/et#!/activeTab=tab02");
      //  System.out.println(contents);

        Document document = Jsoup.parse(contents);
        Elements elements = document.select("#endlessProducts");
        System.out.println(elements.size());
        for (Element e : elements) {
             String title = e.select("js-link-product").text();
            System.out.println(title);
        }

//        final String url = "https://www.rahvaraamat.ee/c/raamatud/1/et#!/activeTab=tab02";
//
//        try {
//            final Document document = Jsoup.connect(url).get();
//            System.out.println(document.outerHtml());
//            Elements pageElements = document.select("a href");
//
//            ArrayList<String> hyperLinks = new ArrayList<String>();
//
//            for (Element e : pageElements) {
//                hyperLinks.add("Text" + e.text());
//                hyperLinks.add("Link:" + e.attr("href"));
//            }
//            for (String s : hyperLinks) {
//                System.out.println(s);
//            }

//            for(Element ul : document.select(
//                    "endlessProducts")){
//                if (ul.select("meta").text().equals("")){
//                    continue;
//                }
//                else {
//                    final String query =  ul.select("meta").text();
//                    System.out.println(query);
//
//                }
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
