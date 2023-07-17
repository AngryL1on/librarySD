package ru.rutmiit.Library.controllers;

public class ReaderNotFoundException extends RuntimeException {

    public ReaderNotFoundException(String message) {
        super(message);
    }
}