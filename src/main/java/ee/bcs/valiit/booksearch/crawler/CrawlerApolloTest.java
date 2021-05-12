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
//public class CrawlerApolloTest {
//
//    private BookRepository bookRepository;
//
//    public CrawlerApolloTest(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public static void main(String[] args) {
//
////    }
//////
////    public void bookScrapingResultApollo() {
//        int storeId = 1;
//        //1. Selle Crawleri teen eraldi meetodiks, et tagastaks listi
//        String url = "https://www.apollo.ee/raamatud/eestikeelsed-raamatud?";
//        //String url = "https://www.apollo.ee/edetabel/raamatute-topid/eestikeelsete-raamatute-nadala-top-10?";
//        List<BookData> bookDataList = new ArrayList<>();
//        for (int i = 1; i <= 1; i++) {
//            String newUrl = url + "p=" + i;
//            String contents = WebReader.readWeb(newUrl);
//            Document document = Jsoup.parse(contents);
//
//            Elements elements = document.select("div.products-grid .item");
////            System.out.println(elements.size());
//            for (Element e : elements) {
//                BookData bookData = new BookData();
//                Elements productName = e.getElementsByClass("product-name");
////                String bookTitle = productName.get(0).getElementsByTag("a").get(0).attributes().get("title");
////                bookData.setBookTitle(bookTitle);
////                String author = e.getElementsByClass("author").text();
////                bookData.setAuthor(author);
////                String price = e.getElementsByClass("regular-price").text();
////                if (price!="") {
////                    bookData.setPrice(price);
////                } else continue;
////                //String priceToDouble = price.(0, price.length()-2);
//                String urlPage = productName.get(0).getElementsByTag("a").get(0).attributes().get("href");
//                String productUrl = urlPage;
//                String contents2 = WebReader.readWeb(productUrl);
//                Document document1 = Jsoup.parse(contents2);
//                Elements elements1 = document1.select("ul");
// //               System.out.println(elements1.size());
//                for (Element e1 : elements1) {
//                    String listItem = e1.getElementsContainingText("Kirjastus").text();
//                    if(!listItem.isBlank()){
//                        int index = listItem.indexOf("formaat:");
//                        String format = listItem.substring(index + 9, index + 23);
//                        int index2 = listItem.indexOf("aasta:");
//                        String year = listItem.substring(index2 + 7, index2 + 11);
//                        int index3 = listItem.indexOf("Ribakood:");
//                        String isbn = listItem.substring(index3 + 10, index3 + 23);
//                        System.out.println(format + " " + isbn);
//                    }
//                }
//
////                bookData.setUrlPage(urlPage);
//                //  System.out.println(urlPage);
//                //int storeId = 1;
////                bookData.setStoreId(storeId);
////                Elements productImage = e.getElementsByClass("image-wrapper");
////                String urlImage = productImage.get(0).getElementsByTag("img").get(0).attributes().get("src");
////                bookData.setUrlImage(urlImage);
////                int index = urlImage.lastIndexOf("/");
////                String isbn = urlImage.substring(index + 1, urlImage.length() - 4);
////                index = isbn.indexOf("_");
////                if (index >= 0){
////                    isbn = isbn.substring(0, index);
////                }
////                else isbn=urlImage.substring(urlImage.lastIndexOf("/")+1, urlImage.length()-4);
//                //System.out.println(isbn);
////                bookData.setIsbn(isbn);
////                bookDataList.add(bookData);
//            }
//        }
//
//        // kui tahame teist korda crawleri tööle panna, siis tuleb esmalt tabel tühjendada:
////
////        bookRepository.deleteBooks(storeId);
////
////        for (BookData bookData : bookDataList) {
////
////            //select ja update repos kui tahame asendada/uuendada raamtute andmeid,
////            // siis ei kasuta deleteApolloBooks meetodit (double hinna lahtrisse)
////
////            bookRepository.saveBooks(bookData);
//    }
//
//}
//
////}
