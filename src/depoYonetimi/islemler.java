package depoYonetimi;
import java.util.*;

public class islemler {
    static Scanner scan = new Scanner(System.in);
    public static Map<Integer, urunTanimlama> urunListesiMap = new HashMap<Integer, urunTanimlama>();
    public static int urunId = 1000;

    public static void girisPaneli() {
        System.out.println("====================================\nDEPO YONETIM PANELI\n" +
                "====================================\n"
                + "1- URUN TANIMLAMA\n2- URUN LİSTELE\n3- URUN GİRİŞİ\n4- URUNU RAFA KOY\n5- URUN ÇIKIŞI\n6- DEPODAN ÇIKIŞ");
        System.out.print("isleminiz seciniz : ");
        String secim = scan.next().toUpperCase(Locale.ROOT);
        switch (secim) {
            case "1":
                urunTanimla();
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
            case "6":
                cikis();
                break;
            default:
                System.out.println("hatalı giriş yaptınız, tekrar deneyiniz. ");
                girisPaneli();
                break;
        }
    }

    private static void cikis() {
        System.out.println(" depo dan çıkış yaptınız. tekrar bekleriz..");
    }

    private static void urunTanimla() {
        System.out.println("   ********* urun tanımlama sayfası *********");
        System.out.println("ürün ismi giriniz: ");
        String urunIsmi = scan.nextLine();
        scan.next();//dummy
        System.out.println("üreticisini giriniz: ");
        String uretici = scan.nextLine();
        scan.next();//dummy
        System.out.println("birimi giriniz: ");
        String birim = scan.nextLine();
        scan.next();//dummy
        int urunMiktar=0;
        String raf=" - ";

        urunTanimlama urun = new urunTanimlama(urunIsmi, uretici, birim, urunMiktar, raf);
        urunListesiMap.put(urunId, urun);

        urunId++;

    }

    private static void urunCikisi() {
        System.out.println("   ********* urun çıkış sayfası ********* ");
        System.out.print("Cıkısını yapmak  istediginiz urunun ID sini giriniz : ");

        int arananId = scan.nextInt();
        if (urunListesiMap.keySet().contains(arananId)) {
            System.out.println("miktar giriniz");
            int guncelmiktar = 0;
            boolean flag = true;
            do {
                try {
                    if (flag == true) { scan.nextLine(); }
                    guncelmiktar = scan.nextInt();
                    scan.nextLine();//dummy
                    flag = false;
                } catch (Exception e) {
                    System.out.println("lütfen geçerli bir tamsayı giriniz");
                }
            } while (flag);
          int sonuc=urunListesiMap.get(arananId).getUrunMiktar()-guncelmiktar;

           if (sonuc<0){
              System.out.println("deponuzda bu miktarda ürün yoktur.\n bulunan miktar: "+urunListesiMap.get(arananId).getUrunMiktar());
           }else{
              urunListesiMap.get(arananId).setUrunMiktar(sonuc);
              System.out.println("urun miktarınız güncel hale getirildi\n güncel miktar: "+urunListesiMap.get(arananId).getUrunMiktar());
           }

        } else {
            System.out.println("aradığınız ürün yoktur");
        }
    }

    private static void urunuRafaKoy() {
        System.out.println("   ********* urunu rafa ekleme sayfası ********* ");
        System.out.print("Rafa yerlestirmek istediginiz urunun ID sini giriniz : ");
        int arananId=scan.nextInt();
        if (urunListesiMap.keySet().contains(arananId)){
            System.out.println("hangi rafa kaldıracağınızı yazınız:");
            String guncelraf = scan.next();

            urunListesiMap.get(arananId).setRaf(guncelraf);

        }else{
            System.out.println("bu ürün depoda mevcut değildir malesef ");
        }

    }

    private static void urunGirisi() {
        System.out.println("   ********* urun giriş sayfası ********* ");

        System.out.println("güncellemek istediğiniz ürün id si giriniz:");
        int arananId = scan.nextInt();
        if (urunListesiMap.keySet().contains(arananId)) {
            System.out.println("miktar giriniz");
            int guncelmiktar = 0;
            boolean flag = true;
            do {
                try {
                    if (flag == true) { scan.nextLine(); }
                    guncelmiktar = scan.nextInt();
                    scan.nextLine();//dummy
                    flag = false;
                } catch (Exception e) {
                    System.out.println("lütfen geçerli bir giris yapınız");
                }
            } while (flag);

            urunListesiMap.get(arananId).setUrunMiktar(guncelmiktar + urunListesiMap.get(arananId).getUrunMiktar());
            System.out.println("urun miktarınız güncel hale getirildi");
        } else {
            System.out.println("aradığınız ürün yoktur");
        }
    }

    private static void urunListele() {

        Set<Map.Entry<Integer,urunTanimlama>> urunEntrySeti = urunListesiMap.entrySet();
        System.out.println("---------------------------ÜRÜN LİSTESİ---------------------------------");
        System.out.println("id       ismi         ureticisi       birim       miktar         raf" +
                "\n----------------------------------------------------------------------");

        for (Map.Entry<Integer,urunTanimlama> e: urunEntrySeti
        ) {

            Integer entryKey= e.getKey();
            System.out.printf( "%-8d %-12s %-15s %-12s %-12d %-9s\n" , entryKey, urunListesiMap.get(entryKey).getUrunIsmi(),urunListesiMap.get(entryKey).getUretici(),urunListesiMap.get(entryKey).getBirim(),urunListesiMap.get(entryKey).getUrunMiktar(),urunListesiMap.get(entryKey).getRaf());
        }

    }
    }




