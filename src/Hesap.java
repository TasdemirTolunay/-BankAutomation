import java.sql.*;
import java.util.Scanner;

public class Hesap {
    private String kullaniciAdi = "root";
    private String kullaniciSifre = "";
    private String host = "localhost";
    private String dbName = "hesap";
    private int port = 3306;
    private Connection con = null;
    private Statement statement = null;
    private int bakiye;
    Scanner scanner = new Scanner(System.in);


    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public Hesap(){
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url,kullaniciAdi,kullaniciSifre);
            System.out.println("Hesap database baglantisi gerceklesti......");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void bilgiGirisi(){
        try {
            statement = con.createStatement();
            System.out.print("Isminizi giriniz = ");
            String isim = scanner.nextLine();
            System.out.print("Soyisminizi giriniz = ");
            String soyisim = scanner.nextLine();
            System.out.print("Baslangic bakiyenizi giriniz = ");
            bakiye = scanner.nextInt();
            scanner.nextLine(); // dummy
            String hesapSorgu = "Insert into bakiye (ad,soyad,hesapBakiye) Values (" + "'" + isim + "', '" + soyisim + "', '" + bakiye + "')";
            statement.executeUpdate(hesapSorgu);
            System.out.println("Bigileriniz kaydedilmistir tesekkur ederiz....");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void bakiyeAtama(int id){
        String bakiyeSorgu = "Select * from bakiye where " + "id = " + id;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(bakiyeSorgu);
            while(rs.next()) {
                bakiye = rs.getInt("hesapBakiye");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void bakiyeGoruntule(int id){
        String bakiyeSorgu = "Select * from bakiye where " + "id = " + id;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(bakiyeSorgu);
            while(rs.next()) {
                bakiye = rs.getInt("hesapBakiye");
                System.out.println("Hesabinizdaki bakiye = " + bakiye + " TL`dir.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void paraCekme(int id){
        try {
            statement = con.createStatement();
            while(true) {
                System.out.print("Hesabinizdan cekmek istediginiz tutari giriniz = ");
                int cekme = scanner.nextInt();
                scanner.nextLine(); // dummy
                if(cekme > bakiye){
                    System.out.println("Hesap bakiyeniz yetersiz.....");
                    System.out.println("Para cekme isleminden cikmak ister misiniz? (evet-hayir) ");
                    String cevap1 = scanner.nextLine();
                    if(cevap1.equals("evet")){
                        break;
                    }
                }else{
                    bakiye = bakiye - cekme;
                    break;
                }
            }
            String cekmeSorgu = "Update bakiye Set hesapBakiye = " + bakiye + " where id = " + id;
            statement.executeUpdate(cekmeSorgu);
            System.out.println("Yeni bakiyeniz = " + bakiye);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void paraYatirma(int id){
        try {
            statement = con.createStatement();
            while(true){
                System.out.print("Yatirmak istediginiz tutari giriniz = ");
                int tutar = scanner.nextInt();
                scanner.nextLine(); // dummy
                System.out.println("Yeni bakiyeniz = " + (tutar + bakiye) + " TL`dir.....");
                bakiye = bakiye + tutar;
                System.out.print("Tekrar para yatirmak istiyor musunuz? (evet-hayir) ");
                String cevap = scanner.nextLine();
                if(cevap.equals("hayir")){
                    break;
                }
            }
            String yatirmaSorgu = "Update bakiye Set hesapBakiye = " + bakiye + " where id = " + id;
            statement.executeUpdate(yatirmaSorgu);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void bilgilerimiGoruntule(int id){
        String bilgiSorgu = "Select * from bakiye where id = " + id;

        try {
            statement = con.createStatement();
            ResultSet rs1 = statement.executeQuery(bilgiSorgu);
            while(rs1.next()){
                String isim1 = rs1.getString("ad");
                String soyisim1 = rs1.getString("soyad");
                int bakiye1 = rs1.getInt("hesapBakiye");
                System.out.println("Isim: " + isim1 + " Soyisim: " + soyisim1 + " Bakiye: " + bakiye1 + " TL");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
