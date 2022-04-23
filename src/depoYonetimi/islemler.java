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

    }



    private static void urunuRafaKoy() {

    }

    private static void urunGirisi() {
        //urunGirisi 		==> giris yapmak istedigimiz urnunun id numarasi ile girecegiz.
        System.out.println("girmek istediğiniz ürünün id'sini yazınız: ");
        urunId= scan.nextInt();

        if(urunListesiMap.containsKey(urunId)){
            System.out.println( urunListesiMap.get(urunId));
            System.out.println("girmek istediğiniz miktarı yazınız: ");
           urunMiktar= scan.nextInt();
            System.out.println( urunListesiMap.get(urunId));
            urunListesiMap.compute(urunId,(urunId,urunMiktar)->urunMiktar);

        }else{
            System.out.println("malesef girdiğiniz id bulunamadı");
        }
        System.out.println( urunListesiMap.get(urunId));

    }




    private static void urunListele() {
        Set<Integer> urunListKeySeti = urunListesiMap.keySet();
        List<Integer> keyList=new ArrayList<>();
        keyList.addAll(urunListKeySeti);

        Collection<String> urunListValueColl =urunListesiMap.values();


        List<String> urunValueList=new ArrayList<>();
        urunValueList.addAll(urunListValueColl);

        int outerArrayBoyut= urunValueList.size();

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
        System.out.println("id\t\tismi\t\tureticisi\t\tbirimi\t\tmiktar\t\traf");
        System.out.println("========================================================");
        for (int i = 0; i <keyList.size() ; i++) {
            System.out.print( keyList.get(i)+ "\t\t");
            for (int j = 0; j < innerArrayBoyut; j++) {
                System.out.print(valueMDArr[i][j] + "\t\t");
            }

            System.out.println("");
        }

    }

    private static void urunTanımla() {
        //List<String> urunList= new ArrayList<>();
        //urunTanimlama 	==>  urunun ismi, ureticisi ve birimi girilecek. id  alınacak.
        System.out.println("id giriniz: ");
        urunId=scan.nextInt();

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

        //Map<Integer, List> urunListesiMap = new HashMap<Integer,List>();

        urunListesiMap.put(urunId,(urunIsmi+", "+uretici+", "+birim+", "+urunMiktar+", "+raf));
        //System.out.println(urunListesiMap);


    }
    }

