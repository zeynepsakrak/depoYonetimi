package depoYonetimi;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static depoYonetimi.urunTanimlama.urunId;

public class islemler {
    static Scanner scan=new Scanner(System.in);
    static ArrayList<urunTanimlama> urunList=new ArrayList<>();
    public static void girisPaneli(){
        System.out.println("====================================\nDEPO YONETIM PANELI\n" +
                "====================================\n"
                + "1- URUN TANIMLAMA\n2- URUN LİSTELE\n3- URUN GİRİŞİ\n4- URUNU RAFA KOY\n5- URUN ÇIKIŞI");
        System.out.print("isleminiz seciniz : ");
        String secim= scan.next().toUpperCase(Locale.ROOT);
        switch (secim){
            case "1":
                urunTanımla();
                girisPaneli();
                break;
            case "2":
                urunListele();
                girisPaneli();
                break;
            case "3":
                urunGirisi();
                girisPaneli();
                break;
            case "4":
                urunuRafaKoy();
                girisPaneli();
                break;
            case "5":
                urunCikisi();
                girisPaneli();
            break;
            default:
                System.out.println("hatalı giriş yapınız");
                girisPaneli();
                break;
        }
    }

    private static void urunCikisi() {
        urunListeYazdir();
    }



    private static void urunuRafaKoy() {
        urunListeYazdir();
    }

    private static void urunGirisi() {
        urunListeYazdir();
    }

    private static void urunListele() {
        urunListeYazdir();
    }

    private static void urunTanımla() {
        //urunTanimlama 	==>  urunun ismi, ureticisi ve birimi girilecek. id  alınacak.
        System.out.println("ürün ismi giriniz: ");
        String urunIsmi=scan.nextLine();

        scan.next();
        System.out.println("üreticisini giriniz: ");
        String uretici=scan.nextLine();

        scan.next();
        System.out.println("birimi giriniz: ");
        String birim=scan.nextLine();

        scan.next();
        System.out.println("id giriniz: ");
        String id=scan.nextLine();
        scan.next();
        urunTanimlama urunlerimiz=new urunTanimlama(id,urunIsmi,uretici,birim);

        urunList.add(urunlerimiz);
        System.out.println(urunList.toString());
       // urunListeYazdir();
    }


    private static void urunListeYazdir() {
        urunListeYazdir();
    }
}
