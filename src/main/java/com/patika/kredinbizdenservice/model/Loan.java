package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import com.patika.kredinbizdenservice.enums.LoanType;

public abstract class Loan implements Product {

    private BigDecimal amount;
    private Integer installment;
    private Bank bank;
    private Double interestRate;
    // private Campaign campaign; // kampanyalı kredileri üstte çıkart

    //sponsorlu kampanyaları üstte çıkart

    public Loan() {
    }



    public Loan(BigDecimal amount, Integer installment, Double interestRate) {
        this.amount = amount;
        this.installment = installment;
        this.interestRate = interestRate;
    }

    abstract void calculate(BigDecimal amount, int installment);

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "amount=" + amount +
                ", installment=" + installment +
                ", bank=" + bank +
                ", interestRate=" + interestRate +
                '}';
    }

    public static Loan createLoan(LoanType type, BigDecimal amount, Integer installment, Double interestRate) {
        switch (type) {
            case IHTIYAC_KREDISI:
                return new ConsumerLoan(amount, installment, interestRate);
            case KONUT_KREDISI:
                return new HouseLoan(amount, installment, interestRate);
            case ARAC_KREDISI:
                return new VechileLoan(amount, installment, interestRate);
            default:
                throw new IllegalArgumentException("Unknown Loan Type");
        }
    }
}
