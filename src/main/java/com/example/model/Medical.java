package com.example.model;

public enum Medical {
    headache, pills;
    static public Medical find(String value) {
        Medical result = null;
        Medical[] items = Medical.values();
        for(Medical i : items){
            if (value.contains(i.toString()))
                result = i;
        }
        return result;
    }
}
