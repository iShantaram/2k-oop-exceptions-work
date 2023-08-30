package com.hw;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String s) {
        super(s);
    }
}
