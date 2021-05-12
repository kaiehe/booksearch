package ee.bcs.valiit.booksearch;

public class Main {
    public static void main(String[] args) {
        String a = "https://meedia.apollo.ee/media/catalog/product/cache/1/small_image/160x/17f82f742ffe127f42dca9de82fb58b1/9/7/9789949080977.jpg";
        String b = "https://meedia.apollo.ee/media/catalog/product/cache/1/small_image/160x/17f82f742ffe127f42dca9de82fb58b1/9/7/9789916404676_2.png";
//        System.out.println(getIsbn(a));
//        System.out.println(getIsbn(b));
        String c = "Alapealkiri: Kuidas toetada kõnehilistusega lapse kõne arengut Tootekood: 9789916629024 Ribakood: 9789916629024 Lisamise aeg: 29.04.2021 Autor: Kristi Sarapuu, Merit Hallap Kirjastus: OÜ Studium Ilmumisaasta: 2021 Keel: Eesti Raamatu formaat: Pehmekaaneline Lehekülgi: 64 Mõõdud: 235x165x10 Kirjastus: OÜ Studium Kirjastus:";
        System.out.println(getFormat(c));
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

    private static String getFormat(String c) {
        int index = c.indexOf("Ribakood:");
//        c = c.substring(index);
        c = c.substring(index+10, index+23);
        return c;
    }


}
