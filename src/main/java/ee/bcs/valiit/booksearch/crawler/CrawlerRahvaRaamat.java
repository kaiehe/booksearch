package ee.bcs.valiit.booksearch.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CrawlerRahvaRaamat {

    public static void main(String[] args) {

        final String url ="https://www.rahvaraamat.ee/c/raamatud/1/et#!/activeTab=tab02";

        try {
            final Document document = Jsoup.connect(url).get();
            System.out.println(document.outerHtml());

            for(Element row : document.select(
                    "table.type01")){
                if (row.select("tr:nth-of-type(1)").text().equals("")){
                    continue;
                }
                else {
                    final String ticker =  row.select("tr:nth-of-type(1)").text();
                    System.out.println(ticker);

                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
