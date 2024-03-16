package com.patika.kredinbizdenservice.model;
import java.math.BigDecimal;
public class OnlineAlisverisSistemi {
    public static void main(String[] args) {
        Musteri musteri = new Musteri("Ahmet");

        Urun urun1 = new Urun("Laptop", new BigDecimal("7500"), "Elektronik", 10);
        Urun urun2 = new Urun("Telefon", new BigDecimal("5000"), "Elektronik", 15);

        Siparis siparis = new Siparis();
        siparis.urunEkle(urun1);
        siparis.urunEkle(urun2);

        Fatura fatura = siparis.faturaOlustur();
        musteri.siparisEkle(siparis);

        System.out.println(musteri);
    }
}
