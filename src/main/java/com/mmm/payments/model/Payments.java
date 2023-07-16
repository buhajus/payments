package com.mmm.payments.model;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Payments {


    private int id;
    @DecimalMin(message = "Amount can't be negative ", value = "0.0", inclusive = false)
    private double amount;
    @NotBlank(message = "Currency is mandatory")
    private String currency;
    @NotBlank(message = "Iban is mandatory")
    private String debtor_iban;
    @NotBlank(message = "Iban is mandatory")
    private String creditor_iban;
    private String details;
    private String creditorBankBicCode;
    @NotNull(message = "Payment type is mandatory")
    private PaymentTypes paymentsTypes;
    private String token;


    public Payments(int id, double amount, String currency, String debtor_iban, String creditor_iban, String details, String creditorBankBicCode, PaymentTypes paymentsTypes, String token) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.debtor_iban = debtor_iban;
        this.creditor_iban = creditor_iban;
        this.details = details;
        this.creditorBankBicCode = creditorBankBicCode;
        this.paymentsTypes = paymentsTypes;
        this.token = token;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreditorBankBicCode() {
        return creditorBankBicCode;
    }

    public void setCreditorBankBicCode(String creditorBankBicCode) {
        this.creditorBankBicCode = creditorBankBicCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Payments() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDebtor_iban() {
        return debtor_iban;
    }

    public void setDebtor_iban(String debtor_iban) {
        this.debtor_iban = debtor_iban;
    }

    public String getCreditor_iban() {
        return creditor_iban;
    }

    public PaymentTypes getPaymentsTypes() {
        return paymentsTypes;
    }

    public void setPaymentsTypes(PaymentTypes paymentsTypes) {
        this.paymentsTypes = paymentsTypes;
    }

    public void setCreditor_iban(String creditor_iban) {
        this.creditor_iban = creditor_iban;
    }

}
