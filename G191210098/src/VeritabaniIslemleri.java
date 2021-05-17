import java.sql.*;

public class VeritabaniIslemleri implements IVeritabaniIslemleri{

    private final String URL = "jdbc:postgresql://localhost:5432/db_akilli_cihaz";
    private final String USER = "postgres";
    private final String PASSWORD = "12345";

    public Connection baglan() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Veritabanına başarıyla bağlanıldı...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public boolean kullaniciDogrulama(String kullanici_adi, String sifre) {
        try  {
            Connection connection = this.baglan();
            if(connection != null) {
                String kullaniciAlSQL = "Select * From public.\"kullanici\"";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(kullaniciAlSQL);
                connection.close();

                boolean kontrol = false;
                while(resultSet.next()) {
                    if(resultSet.getString("kullanici_adi").equals(kullanici_adi) && resultSet.getString("sifre").equals(sifre)) {
                        kontrol = true;
                    }
                }

                if(kontrol) {
                    System.out.println("Arayüze Giriş yaptınız...");
                    return true;
                } else {
                    System.out.println("Arayüze Giriş Yapamadınız...");
                    return false;
                }

            } else {
                System.out.println("Veritabanına bağlanılamadı...");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
