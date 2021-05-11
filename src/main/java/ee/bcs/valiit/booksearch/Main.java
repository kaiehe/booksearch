package ee.bcs.valiit.booksearch;

public class Main {
    public static void main(String[] args) {
        String a = "https://meedia.apollo.ee/media/catalog/product/cache/1/small_image/160x/17f82f742ffe127f42dca9de82fb58b1/9/7/9789949080977.jpg";
        String b = "https://meedia.apollo.ee/media/catalog/product/cache/1/small_image/160x/17f82f742ffe127f42dca9de82fb58b1/9/7/9789916404676_2.png";
        System.out.println(getIsbn(a));
        System.out.println(getIsbn(b));
    }

    private static String getIsbn(String a) {
        int index = a.lastIndexOf("/");
        a = a.substring(index + 1, a.length() - 4);
        index = a.indexOf("_");
        if (index >= 0){
            a = a.substring(0, index);
        }
        return a;
    }
}
