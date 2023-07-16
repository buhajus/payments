package com.mmm.payments.controller;

import com.mmm.payments.model.PaymentTypes;
import com.mmm.payments.model.Payments;
import com.mmm.payments.model.config.TokenGenerator;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    Payments payments;


    private List<Payments> paymentsList = new ArrayList<>();


    @GetMapping("/all")
    public List<Payments> getPayments() {

        return paymentsList;
    }


    @PostMapping
    public java.lang.String submitPayment(@RequestBody @Valid Payments payments) {
        TokenGenerator tokenGenerator = new TokenGenerator();
        String token = tokenGenerator.getToken();
        payments.setToken(token);
        //TYPE1
        if (payments.getPaymentsTypes() == PaymentTypes.TYPE1 && payments.getCurrency().equals("USD")) {
            return PaymentTypes.TYPE1 + " payment only accept EUR currency";

        }
        //TYPE1
        if (payments.getPaymentsTypes() == PaymentTypes.TYPE1 && payments.getDetails() == null) {
            return PaymentTypes.TYPE1 + " payment requires details field ";
        }
        //TYPE2
        if (payments.getPaymentsTypes() == PaymentTypes.TYPE2 && payments.getCurrency().equals("EUR")) {
            return PaymentTypes.TYPE2 + " payment only accept USD currency";
        }
        //TYPE3
        if (payments.getPaymentsTypes() == PaymentTypes.TYPE3 &&
                !payments.getCurrency().equals("EUR") && !payments.getCurrency().equals("USD")) {
            return PaymentTypes.TYPE3 + " payment only accept in USD and EUR currency";
        }

        if (payments.getPaymentsTypes() == PaymentTypes.TYPE3 && payments.getCreditorBankBicCode() == null) {
            return PaymentTypes.TYPE3 + " payment requires BIC code";
        } else {

            this.payments = payments;

            paymentsList.add(payments);
            return "Payment sent";
        }

    }

    @DeleteMapping("/delete?id={paymentsId}&token={token}&{time}=true")
    public String cancelTransaction(@PathVariable Integer paymentsId, @PathVariable String token) {

        Iterator<Payments> paymentsIterator = getPayments().iterator();
        while (paymentsIterator.hasNext()) {
            Payments payments1 = paymentsIterator.next();
            if (payments1.getToken().equals(token) && payments1.getId() == paymentsId) {
                paymentsIterator.remove();
                return "Payment canceled";
            }
        }

            return "Data doesn't match";

    }


}
