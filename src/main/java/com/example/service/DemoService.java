package com.example.service;

import com.example.dto.Purchase;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoService {

    public String[] splitRows(String value) {
        return value.split("(\n)");
    }
    public List<Purchase> fetchRows(String[] rows) {


        return Arrays.stream(rows).map( el -> {
                String[] pieces = el.split(" ");
                Integer qta = 1;
                Double value = 0.0;
                Boolean imported = false;
                Double tax = 0.0;
                String name = "";

                for (int i = 0; i < pieces.length; i++) {
                    if (i == 0)
                        qta = Integer.parseInt(pieces[i]);
                    else if (i == pieces.length -1)
                        value = Double.parseDouble(pieces[i]);
                    else if (!"at".equals(pieces[i]))
                        name = name.concat(pieces[i]).concat(" ");
                }
                name = name.substring(0, name.length() - 1);
                return new Purchase( name, qta, value);
        }).collect(Collectors.toList());

    }
}
