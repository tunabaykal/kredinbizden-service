package com.patika.kredinbizdenservice.model;

import java.time.LocalDate;
import java.util.List;    import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email; //bir email ile bir kere kayıt olunabilir.
    private String password; //hash fonskiyonlarından biri ile hashlanecek.
    private String phoneNumber;
    private Boolean isActive;
    private List<Application> applicationList;

    public User(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public User(String name, String surname, String email, String password, String phoneNumber, Boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }



    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] hashedPassword = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = hashPassword(password); // Örnek olarak
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }


}
