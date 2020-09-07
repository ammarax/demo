package com.example.controller;

import com.example.service.DemoService;
import com.example.dto.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/calc")
    public String calcResult(@RequestParam(value = "content", defaultValue = "") String name) {

        String[] rows = demoService.splitRows(name);
        List<Purchase> chart = demoService.fetchRows(rows);
        String result = new String();

        Double salesTaxes = 0.00;
        Double total = 0.00;

        for(Purchase p : chart) {
            result = result.concat(p.toString()).concat("<br>");
            salesTaxes += p.getTax();
            total += p.getTaxesValue();
        }

        return result
                + "<br> Sales Taxes: "  + String.format("%.2f", salesTaxes )
                + "<br> Total: " +  String.format("%.2f", total );

    }

}
