package ru.rutmiit.Library.dtos;

public class ReaderDto {
    private int readerId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public ReaderDto (int readerId, String name, String email, String address, String phoneNumber) {
        this.readerId = readerId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public ReaderDto() {
    }

    public int getReaderId() {
        return readerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
