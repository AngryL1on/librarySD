package ru.rutmiit.Library.controllers;

public class LibrarianNotFoundException extends RuntimeException {

    public LibrarianNotFoundException(String message) {
        super(message);
    }
}

