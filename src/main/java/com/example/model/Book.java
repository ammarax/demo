package com.example.model;

public enum Book {
    book;
    static public Book find(String value) {
        Book result = null;
        Book[] items = Book.values();
        for(Book i : items){
            if (value.contains(i.toString()))
                result = i;
        }
        return result;
    }
}
