import java.util.Random;

public class SicaklikAlgilayici implements  ISicaklikAlgilayici{


    @Override
    public int sicaklikOku() {
        Random random = new Random();
        int sayi = random.nextInt(60);
        return sayi;
    }

    @Override
    public int sicaklikGonder() {
        System.out.println("Sicaklik: "+sicaklikOku()+" Derece");
        return sicaklikOku();
    }
}
