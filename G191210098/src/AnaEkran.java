import java.util.Scanner;

public class AnaEkran implements IAnaEkran{

    private static final int SICAKLIK_OLC = 1;
    private static final int SOGUTUCU_AC = 2;
    private static final int SOGUTUCU_KAPA = 3;
    private static final int CIKIS = 4;

    String kullaniciAdi, sifre;


    private IVeritabaniIslemleri veritabaniIslemleri;
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private AgArayuzu arayuz;
    Uyari uyari;

    public AnaEkran() {
        sicaklikAlgilayici = new SicaklikAlgilayici();
        veritabaniIslemleri = new VeritabaniIslemleri();
        eyleyici = new Eyleyici();
        arayuz = new AgArayuzu();
        uyari = new Uyari();
    }
    Scanner scanner = new Scanner(System.in);




    public AnaEkran(Builder builder) {
        this.scanner = new Scanner(System.in);
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }


    public Scanner getScanner() {
        return scanner;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String string) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(int anInt) {
        this.sifre = sifre;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static class Builder{

        private String kullaniciAdi;
        int sifre;

        public Builder(){ }

        public Builder kullaniciAdi(String kullaniciAdi){
            this.kullaniciAdi = kullaniciAdi;
            return this;
        }

        public Builder sifre(int sifre){
            this.sifre = sifre;
            return this;
        }

        public AnaEkran build(){
            return new AnaEkran(this);
        }

    }

    @Override
    public boolean baslat() {
        int hak = 0;
        System.out.println("\nHoşgeldiniz, Kullanıcı Adınızı ve Şifrenizi Giriniz...");
        do {

            System.out.print("\nKullanici Adınız: ");
            kullaniciAdi = scanner.next();
            System.out.print("Şifreniz: ");
            sifre = scanner.next();
            boolean kontrol;
            kontrol = veritabaniIslemleri.kullaniciDogrulama(kullaniciAdi,sifre);


            if(kontrol) {
                islemSecimi();
            } else {
                hak++;
            }

        } while(hak != 3);
        System.out.println("3 Deneme Hakkınızı Doldurdunuz...");
        System.out.println("Program Sonlandırılıyor...");
        return false;
    }






    private void islemSecimi(){
        int secim;
        do{
            secim=anaMenuyuGoster();
            switch (secim) {
                case SICAKLIK_OLC:
                    sicaklikAlgilayici.sicaklikOku();
                    sicaklikAlgilayici.sicaklikGonder();
                    break;
                case SOGUTUCU_AC:
                    eyleyici.sogutucuAc();
                    break;

                case SOGUTUCU_KAPA:
                    eyleyici.sogutucuKapa();
                    break;

                case CIKIS:
                    System.out.println("Çıkılıyor...");
                    arayuz.cikis();
                    break;
                default:
                    System.out.println("1-4 arasında bir sayı girmelisiniz");
                    break;
            }
        }while(secim!=4);
    }


    private int anaMenuyuGoster()
    {
        System.out.println("**********************************************");
        System.out.println("Ana Menu");
        System.out.println("1-Sıcaklık Ölç");
        System.out.println("2-Soğutucu Aç");
        System.out.println("3-Soğutuc Kapa");
        System.out.println("4-Cikis");
        System.out.println("Seciminiz:");
        System.out.println("**********************************************");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
