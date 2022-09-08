package com.example.challenge;

public class exception extends RuntimeException{
    exception(Long id) {
        super("Could not find item" + id);
    }
}
