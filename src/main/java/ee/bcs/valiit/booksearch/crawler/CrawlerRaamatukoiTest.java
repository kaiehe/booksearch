//package ee.bcs.valiit.booksearch.crawler;
//
//import ee.bcs.valiit.booksearch.BookData;
//import ee.bcs.valiit.booksearch.repository.BookRepository;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CrawlerRaamatukoiTest {
//    private BookRepository bookRepository;
//
//    public CrawlerRaamatukoiTest(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public static void main(String[] args) {
//
////    }
////    public void bookScrapingResultRaamatukoi() {
//        int storeId = 4;
//        String url = "https://www.raamatukoi.ee/uued-raamatud?";
//        List<BookData> bookDataList = new ArrayList<>();
//
//        for (int i = 1; i <= 36; i++) {
//            String newUrl = url + "p=" + i;
//            String contents = WebReader.readWeb(newUrl);
//            Document document = Jsoup.parse(contents);
//            Elements elements = document.select("ol.filterproducts.products.list.items.product-items li.item");
//
//            for (Element e : elements) {
////                BookData bookData = new BookData();
////                String autor = e.getElementsByClass("autor-list").text();
////                bookData.setAuthor(autor);
////                String bookTitle = e.getElementsByClass("product-item-link").text();
////                bookData.setBookTitle(bookTitle);
////                String yearOfPublishing = e.getElementsByClass("aasta-list").text();
////                bookData.setYearOfPublishing(yearOfPublishing);
////                Elements productImage = e.getElementsByTag("a");
////                String urlImage = productImage.get(0).getElementsByTag("img").get(0).attributes().get("src");
////                bookData.setUrlImage(urlImage);
////                String price = e.getElementsByClass("price").text();
////                bookData.setPrice(price);
//                Elements productUrl = e.getElementsByTag("strong");
//                String urlData = productUrl.get(0).getElementsByTag("a").get(0).attributes().get("href");
//                String productUrl2 = urlData;
//                String contents2 = WebReader.readWeb(productUrl2);
//                Document document1 = Jsoup.parse(contents2);
//                Elements elements1 = document1.select("tr");
////                System.out.println(elements1.size());
//                for (Element e1 : elements1) {
//                    String listItem = e1.getElementsContainingText("köide").text();
//                    if (!listItem.isBlank()) {
//                        listItem = listItem.substring(6);
////                        System.out.println(listItem);
//                    }
//                    String listItem2 = e1.getElementsContainingText("EAN").text();
//                    if (!listItem2.isBlank()) {
//                        listItem2 = listItem2.substring(4, listItem2.length()-4);
//                        System.out.println(listItem2);
//                    }
//                    }
//
////                bookData.setUrlPage(urlData);
////
////                bookData.setStoreId(storeId);
////                bookDataList.add(bookData);
//                //System.out.println(autor + " " + bookTitle + " " + yearOfPublishing);
//            }
//        }
////        bookRepository.deleteBooks(storeId);
//
////        for (BookData bookData : bookDataList) {
////            bookRepository.saveBooks(bookData);
//        }
//    }
////}
