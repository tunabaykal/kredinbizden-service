package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;

public class Fatura {
    private BigDecimal tutar;

    public Fatura(BigDecimal tutar) {
        this.tutar = tutar;
    }

    public BigDecimal getTutar() {
        return tutar;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "tutar=" + tutar +
                '}';
    }
}
