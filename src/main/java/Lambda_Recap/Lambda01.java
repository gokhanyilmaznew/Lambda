package Lambda_Recap;
////Lamba Map haric tum Collection uyelerinde kullanabiliriz.
// Map'lerde key value iliskisi oldugu icin kullanamayiz
import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(-5, -8, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        ciftVePozitifLamexYazdir(sayi);
        System.out.println("\n *******");
        ciftVePozitifMetRef(sayi);
        System.out.println("\n *******");
        kareYazdir(sayi);
        System.out.println("\n *******");
        kareRekrarsiz(sayi);
        System.out.println("\n *******");
        buyKucSirala(sayi);
        System.out.println("\n *******");
        pozitifKupBirlerBas5(sayi);
        System.out.println("\n *******");
        toplamMetRef(sayi);
        System.out.println("\n *******");
        toplamLamdaEx(sayi);
        System.out.println("\n *******");
        System.out.println(ciftElKareKucBuySirListReturn(sayi));


    }

    //SORU1: List elemanlarının çift ve pozitif olanlarını, Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın
    public static void ciftVePozitifLamexYazdir(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.print(t + " "));
    }

    //SORU2: List elemanlarının çift ve pozitif olanlarını, Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın
    public static void ciftVePozitifMetRef(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 && t > 0).forEach(Utils::yazdir);
    }

    //SORU3 : List elemanlarının karelerini, aralarında bosluk olacak sekilde yazdırın
    public static void kareYazdir(List<Integer> sayi) {
        sayi.stream().map(Utils::kareBul).forEach(Utils::yazdir);
    }

    //SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın
    public static void kareRekrarsiz(List<Integer> sayi) {
        sayi.stream().map(Utils::kareBul).distinct().forEach(Utils::yazdir);
    }

    //SORU5: List elemanlarını buyukten kucuge sıralayarak yazdırın
    public static void buyKucSirala(List<Integer> sayi) {
        sayi.stream().sorted(Comparator.reverseOrder()).forEach(Utils::yazdir);
    }

    // SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup, birler basamagı 5 olanları yazdırınız.
    public static void pozitifKupBirlerBas5(List<Integer> sayi) {
        sayi.stream().filter(t -> t > 0).map(Utils::kupBul).filter(t -> t % 10 == 5).forEach(Utils::yazdir);
    }

    // SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın
    public static void toplamMetRef(List<Integer> sayi) {
        Optional<Integer> sonuc = sayi.stream().reduce(Integer::sum);
        System.out.println(sonuc);
    }

    // SORU8: List elemanlarının Lambda Expression ile toplamını bulun ve yazdırın
    public static void toplamLamdaEx(List<Integer> sayi) {
        int sonuc = sayi.stream().reduce(0, (t, u) -> t + u);
        System.out.println(sonuc);
    }

    //SORU9 : Listin cift elemanlarının, karelerini, kucukten buyuge sıralayıp list halinde return ederek yazdırınız
    public static List<Integer> ciftElKareKucBuySirListReturn(List<Integer> sayi) {
      List<Integer>sonuc=  sayi.stream().filter(t -> t % 2 == 0).map(Utils::kareBul).sorted().collect(Collectors.toList());
        return sonuc;
    }


}


