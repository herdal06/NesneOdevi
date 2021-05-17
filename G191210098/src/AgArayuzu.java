public class AgArayuzu implements IAgArayuzu,IObserver{


    public void sicaklikGonder(ISicaklikAlgilayici sicaklikAlgilayici) {
        sicaklikAlgilayici.sicaklikGonder();
    }
    public void sogutucuAc(IEyleyici eyleyici) {

        eyleyici.sogutucuAc();
    }
    public void sogutucuKapat(IEyleyici eyleyici) {

        eyleyici.sogutucuKapa();
    }
    public void cikis() {

        System.out.println("Oturumunuz Sonlandırıldı...");
    }

    @Override
    public void guncelle(int sicaklik) {
        System.out.println("Sıcaklık güncellendi...");
    }
}
