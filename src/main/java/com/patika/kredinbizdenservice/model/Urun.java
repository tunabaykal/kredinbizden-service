package com.patika.kredinbizdenservice.model;
import java.math.BigDecimal;
public class Urun {
    private String isim;
    private BigDecimal fiyat;
    private String kategori;
    private int stok;

    public Urun(String isim, BigDecimal fiyat, String kategori, int stok) {
        this.isim = isim;
        this.fiyat = fiyat;
        this.kategori = kategori;
        this.stok = stok;
    }

    // Getter ve Setter Metotları
    public String getIsim() {
        return isim;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public String getKategori() {
        return kategori;
    }

    public int getStok() {
        return stok;
    }

    @Override
    public String toString() {
        return "Ürün{" +
                "isim='" + isim + '\'' +
                ", fiyat=" + fiyat +
                ", kategori='" + kategori + '\'' +
                ", stok=" + stok +
                '}';
    }
}
