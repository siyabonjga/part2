/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.user.java;

/**
 *
 * @author Student
 */
public class UserJava {

    public static void main(String[] args) {
      class User {

    String username;
    String password;
 
    // Username must contain _ and max 5 chars
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password at least 8 chars
    public boolean checkPassword(String password) {
        return password.length() >= 8;
    }

    // SA number check
    public boolean checkPhoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() <= 12;
    }

    public void register(String username, String password, String phone) {

        if (checkUsername(username)) {
            this.username = username;
        } else {
            System.out.println("Username incorrect");
            return;
        }

        if (checkPassword(password)) {
            this.password = password;
        } else {
            System.out.println("Password incorrect");
            return;
        }

        if (checkPhoneNumber(phone)) {
        } else {
            System.out.println("Phone incorrect");
            return;
        }

        System.out.println("Registration successful");
    }

    public boolean login(String user, String pass) {

        if (user.equals(username) && pass.equals(password)) {

            System.out.println("Login successful");
            return true;
        }

        System.out.println("Login failed");
        return false;
    }
}

    }
}
