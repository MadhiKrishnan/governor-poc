package com.fyndna.fcrapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class UPIController {
    @Autowired
    private Environment env;

    @GetMapping("/balance-inquiry")
    public String upiPayment(@RequestParam("accountNo") String accountNo) {
        String response = null;
        try {
            long timeout = getTimeOut("balance-inquiry");
            Thread.sleep(timeout);
            BigDecimal balance = new BigDecimal("10000");
            response = "balance-inquiry successful for accountNo: " + accountNo + " balance: " + balance + "!";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/upi-payment")
    public String upiPayment(@RequestParam("accountNo") String accountNo, @RequestParam("txnAmount") BigDecimal txnAmount) {
        String response = null;
        try {
            long timeout = getTimeOut("upi-payment");
            Thread.sleep(timeout);
            response = "upi-payment successful for accountNo: " + accountNo + " for txnAmount: " + txnAmount + "!";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    private long getTimeOut(String apiName) {
        long timeout = Integer.parseInt(env.getProperty("fcr-timeouts." + apiName));
        return timeout;
    }
}
