package ru.rutmiit.Library.dtos;

public class LibrarianDto {
    private int librarianId;
    private String name;
    private String email;
    private String phoneNumber;

    public LibrarianDto(int librarianId, String name, String email, String phoneNumber) {
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public LibrarianDto() {
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
