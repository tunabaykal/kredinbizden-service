package com.patika.kredinbizdenservice.model;

import java.util.ArrayList;
import java.util.List;

public class Musteri {
    private String isim;
    private List<Siparis> siparisler;

    public Musteri(String isim) {
        this.isim = isim;
        this.siparisler = new ArrayList<>();
    }

    public void siparisEkle(Siparis siparis) {
        this.siparisler.add(siparis);
    }

    public List<Siparis> getSiparisler() {
        return siparisler;
    }

    @Override
    public String toString() {
        return "Müşteri{" +
                "isim='" + isim + '\'' +
                ", siparisler=" + siparisler +
                '}';
    }
}
