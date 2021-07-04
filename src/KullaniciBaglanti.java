import java.sql.*;
import java.util.Scanner;

public class KullaniciBaglanti {

    private String hostKullaniciAdi = "root";
    private String hostParola = "";
    private String host = "localhost";
    private int port = 3306;
    private String dbIsmi = "kullanici";
    private Connection connection = null;
    private Statement statement = null;
    private int i = 0;
    private int kullaniciId;
    Scanner scanner = new Scanner(System.in);

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public KullaniciBaglanti(){
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbIsmi;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url,hostKullaniciAdi,hostParola);
            System.out.println("Kullanici database baglantisi gerceklesti.....");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void kayit(){
        try {
            statement = connection.createStatement();
            System.out.print("Kullanici Adi Belirleyiniz = ");
            String isim = scanner.nextLine();
            System.out.print("Bir parola belirleyiniz = ");
            String parola = scanner.nextLine();
            String sorgu = "Insert into giris (kullaniciAdi,Sifre) Values (" + "'" + isim + "', '" + parola + "')";
            statement.executeUpdate(sorgu);
            System.out.println("Kaydiniz gerceklesmistir.");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void kullaniciGrisi(){
        String sorgu1 = "Select * from giris";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sorgu1);
            System.out.print("Kullanici adinizi giriniz = ");
            String ad = scanner.nextLine();
            System.out.print("Parolanizi giriniz = ");
            String sifre = scanner.nextLine();

            while(rs.next()){

                if(ad.equals(rs.getString("kullaniciAdi")) && sifre.equals(rs.getString("Sifre"))) {

                    i = 1;
                    kullaniciId = rs.getInt("id");

                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




}
