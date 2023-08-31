package com.hw;

import java.util.Scanner;

public class ExceptionsWork {
    public static void main(String[] args) {
        String login, password, confirmPassword;

        System.out.println("Введите логин, пароль и подтверждение пароля через пробел или enter:");

        Scanner in = new Scanner(System.in);
        login = in.next();
        password = in.next();
        confirmPassword = in.next();

        try {
            AuthenticationValidator.checkInputData(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            throw new RuntimeException(e);
        }
    }
}
