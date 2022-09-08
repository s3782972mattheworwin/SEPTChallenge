package com.example.challenge;

public class exception extends RuntimeException{
    exception(String id) {
        super("Could not find item" + id);
    }
}
