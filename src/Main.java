
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int Id;
        Scanner scanner = new Scanner(System.in);
        KullaniciBaglanti baglanti1 = new KullaniciBaglanti();
        Hesap baglanti2 = new Hesap();
        System.out.println("********* Bankamiza Hosgeldiniz **************");
        while(true) {
            System.out.println("****************************************");
            System.out.println("1. Giris Yap");
            System.out.println("2. Kayit Ol");
            System.out.println("Cikmak icin q`ya basiniz.");
            System.out.println("****************************************");
            String soru1 = scanner.nextLine();
            if (soru1.equals("q")){

                System.out.println("*************** Bankamizi Ziyaret Ettiginiz Icin Tesekkurler *****************");
                return;

            }else if(soru1.equals("2")){
                baglanti1.kayit();
                baglanti2.bilgiGirisi();
                System.out.println("Giris Yapabilirsiniz.....");
            }else if(soru1.equals("1")){

                baglanti1.kullaniciGrisi();
                if(baglanti1.getI() == 0){
                    System.out.println("Hatali Kullanici Adi veya Sifre Girdiniz Tekrar Deneyiniz.......");
                    System.out.println("Sistemde Kaydiniz Yoksa Kayit Olunuz.......");
                }else if(baglanti1.getI() == 1){
                    System.out.println("Giris Isleminiz Gerceklesmistir...");
                    System.out.println("***************** Hosgeldiniz *******************");
                    Id = baglanti1.getKullaniciId();
                    baglanti2.bakiyeAtama(Id);
                    break;
                }else{
                    System.out.println("Yanlis Tuslama Gerceklestirdiniz Tekrar Deneyiniz......");
                }

            }
        }

        while(true){
            System.out.println("**************************************");
            System.out.println("1. Bilgilerimi Goruntule\n" +
                    "2. Bakiye Goruntule\n" +
                    "3. Hesaba Para Yatir\n" +
                    "4. Hesaptan Para Cek\n" +
                    "Cikmak icin q`ya basiniz.");
            System.out.println("***************************************");
            String soru2 = scanner.nextLine();
            if(soru2.equals("q")){
                System.out.println("*************** Bankamizi Ziyaret Ettiginiz Icin Tesekkurler *****************");
                return;
            }else if(soru2.equals("1")){

                baglanti2.bilgilerimiGoruntule(Id);
                System.out.println("**********************************");
                System.out.print("Baska Bir Islem Yapmak Ister misiniz? (evet-hayir) ");
                String yesno1 = scanner.nextLine();
                if(yesno1.equals("hayir")){

                    System.out.println("*************** Bankamizi Ziyaret Ettiginiz Icin Tesekkurler *****************");
                    return;

                }else if(yesno1.equals("evet")){
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.........");
                }else{
                    System.out.println("Yanlis Bir Cevap girdiniz......");
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.........");
                }

            }else if(soru2.equals("2")){
                baglanti2.bakiyeGoruntule(Id);
                System.out.println("********************************************");
                System.out.println("Baska Bir Islem Yapmak Ister misiniz? (evet-hayir) ");
                String yesno2 = scanner.nextLine();
                if(yesno2.equals("hayir")){

                    System.out.println("*************** Bankamizi Ziyaret Ettiginiz Icin Tesekkurler *****************");
                    return;

                }else if(yesno2.equals("evet")){
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.........");
                }else{
                    System.out.println("Yanlis Bir Cevap girdiniz......");
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.........");
                }

            }else if(soru2.equals("3")){
                baglanti2.paraYatirma(Id);
                System.out.println("**************************************");
                System.out.println("Baska Bir Islem Yapmak Ister misiniz? (evet-hayir) ");
                String yesno3 = scanner.nextLine();
                if(yesno3.equals("hayir")){

                    System.out.println("*************** Bankamizi Ziyaret Ettiginiz Icin Tesekkurler *****************");
                    return;

                }else if(yesno3.equals("evet")){
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.........");
                }else{
                    System.out.println("Yanlis Bir Cevap girdiniz......");
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.........");
                }
            }else if(soru2.equals("4")){
                baglanti2.paraCekme(Id);
                System.out.println("**************************************");
                System.out.println("Baska Bir Islem Yapmak Ister misiniz? (evet-hayir) ");
                String yesno3 = scanner.nextLine();
                if(yesno3.equals("hayir")){

                    System.out.println("*************** Bankamizi Ziyaret Ettiginiz Icin Tesekkurler *****************");
                    return;

                }else if(yesno3.equals("evet")){
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.........");
                }else{
                    System.out.println("Yanlis Bir Cevap girdiniz......");
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.........");
                }

            }

        }
    }
}
