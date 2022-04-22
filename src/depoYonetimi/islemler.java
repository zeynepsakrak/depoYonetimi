package depoYonetimi;

import java.util.*;

import static depoYonetimi.urunTanimlama.*;

public class islemler {
    static Scanner scan=new Scanner(System.in);
    public static List<String> urunList= new ArrayList<>();
    public static  Map<Integer,String> urunListesiMap = new HashMap<Integer,String>();
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
            case "2": //Jasmina, zeynep, merve
                urunListele();
                girisPaneli();
                break;
            case "3": // oğuzhan, fatih
                urunGirisi();
                girisPaneli();
                break;
            case "4"://gökhan, hüseyin
                urunuRafaKoy();
                girisPaneli();
                break;
            case "5":// defne, şule
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
        //List<String> urunList= new ArrayList<>();
        //urunTanimlama 	==>  urunun ismi, ureticisi ve birimi girilecek. id  alınacak.
        System.out.println("ürün ismi giriniz: ");
        urunIsmi=scan.next();
        urunList.add(urunIsmi);
        //scan.next();
        System.out.println("üreticisini giriniz: ");
        uretici=scan.next();
        urunList.add(uretici);
        //scan.next();
        System.out.println("birimi giriniz: ");
        birim=scan.next();
        urunList.add(birim);
        //scan.next();

        System.out.println("id giriniz: ");
        urunId=scan.nextInt();

        //Map<Integer, List> urunListesiMap = new HashMap<Integer,List>();

        urunListesiMap.put(urunId,(urunIsmi+", "+uretici+", "+birim));
        //System.out.println(urunListesiMap);


    }


    private static void urunListeYazdir() {
       // System.out.println(urunListesiMap);
        Set<Integer> urunListKeySeti = urunListesiMap.keySet();

        List<Integer> keyList=new ArrayList<>();
        keyList.addAll(urunListKeySeti);


        Collection<String> urunListValueColl =urunListesiMap.values();
        //System.out.println(urunListValueColl);

        List<String> urunValueList=new ArrayList<>();
        urunValueList.addAll(urunListValueColl);

        //System.out.println(urunValueList);

        int outerArrayBoyut= urunValueList.size();


        // inner array'lerin boyutunu bulmak biraz daha kompleks olacak

        String ilkValue=urunValueList.get(0);
       // System.out.println(ilkValue);
        String ilkValueArray[]=ilkValue.split(", ");
        int innerArrayBoyut=ilkValueArray.length;


        String valueMDArr[][]=new String[outerArrayBoyut][innerArrayBoyut];

        for (int i = 0; i <outerArrayBoyut ; i++) {
            String temp[]=urunValueList.get(i).split(", ");
            for (int j = 0; j <innerArrayBoyut ; j++) {

                valueMDArr[i][j]=temp[j];


            }

        }

        // bu satira kadar key'leri index ile ulasabildigim keyList' e atadim
        // value'leri valueMDArr'e atadim
        // simdi bu key ve value'leri istedigim gibi manuple edebilirim

        System.out.println("id\t\tismi \tureticisi\t\tbirimi");
        System.out.println("=========================================");
        for (int i = 0; i <keyList.size() ; i++) {
            System.out.print( keyList.get(i)+ "\t\t");
            for (int j = 0; j < innerArrayBoyut; j++) {
                System.out.print(valueMDArr[i][j] + "\t\t");
            }

            System.out.println("");
        }


    }
}
