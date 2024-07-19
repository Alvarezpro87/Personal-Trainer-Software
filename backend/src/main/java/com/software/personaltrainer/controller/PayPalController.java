package com.software.personaltrainer.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.software.personaltrainer.service.PayPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paypal")
public class PayPalController {

    @Autowired
    private PayPalService payPalService;

    @Value("${paypal.success.url}")
    private String successUrl;

    @Value("${paypal.cancel.url}")
    private String cancelUrl;

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestParam("total") Double total) {
        try {
            Payment payment = payPalService.createPayment(
                    total,
                    "USD",
                    "paypal",
                    "sale",
                    "Payment description",
                    cancelUrl,
                    successUrl);
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return ResponseEntity.ok(links.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("An error occurred.");
    }

    @GetMapping("/success")
    public ResponseEntity<String> successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = payPalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return ResponseEntity.ok("Payment approved");
            }
        } catch (PayPalRESTException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("An error occurred.");
    }

    @GetMapping("/cancel")
    public ResponseEntity<String> cancelPay() {
        return ResponseEntity.ok("Payment canceled");
    }
}

