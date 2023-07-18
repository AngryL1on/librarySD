package ru.rutmiit.Library.dtos;

import ru.rutmiit.Library.entities.Librarian;

public class ReaderDto {
    private int readerId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    private LibrarianDto librarian;

    public ReaderDto (int readerId, String name, String email, String address, String phoneNumber, LibrarianDto librarian) {
        this.readerId = readerId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.librarian = librarian;
    }

    public ReaderDto() {
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LibrarianDto getLibrarian() {
        return librarian;
    }

    public void setLibrarian(LibrarianDto librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return "ReaderDto{" +
                "readerId=" + readerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", librarian=" + librarian +
                '}';
    }
}
