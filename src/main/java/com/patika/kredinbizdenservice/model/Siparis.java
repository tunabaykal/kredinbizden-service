package com.patika.kredinbizdenservice.model;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
public class Siparis {
    private List<Urun> urunler;
    private Fatura fatura;

    public Siparis() {
        this.urunler = new ArrayList<>();
    }

    public void urunEkle(Urun urun) {
        this.urunler.add(urun);
    }

    public Fatura faturaOlustur() {
        BigDecimal toplamTutar = urunler.stream()
                .map(Urun::getFiyat)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.fatura = new Fatura(toplamTutar);
        return fatura;
    }

    @Override
    public String toString() {
        return "Sipariş{" +
                "ürünler=" + urunler +
                ", fatura=" + fatura +
                '}';
    }
}
