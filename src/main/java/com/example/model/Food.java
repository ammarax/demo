package com.example.model;

public enum Food {
    chocolate;

    static public Food find(String value) {
        Food result = null;
        Food[] items = Food.values();
        for(Food i : items){
            if (value.contains(i.toString()))
                result = i;
        }
        return result;
    }
}
