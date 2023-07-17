package ru.rutmiit.Library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    private String email;

    private String address;

    private String phone;
}
