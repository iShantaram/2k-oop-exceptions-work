package com.hw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionsWork {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String login, password, confirmPassword;
        //while (true) {
            System.out.println("Введите логин, пароль и подтверждение пароля через пробел или enter:");
            login = in.next();
            password = in.next();
            confirmPassword = in.next();

            try {
                checkInputData(login, password, confirmPassword);
            } catch (WrongLoginException | WrongPasswordException e) {
                throw new RuntimeException(e);
                //System.out.println(e.getMessage());
            }
        //}
    }

    public static void checkInputData(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        final int maxLoginLength = 20;
        final int maxPasswordLength = 20;

        /** Создаем шаблоны для недопустимого символа в логине и пароле
         * \w - Символы, соответствующие словам, сокращение от [a-zA-Z_0-9]
         * \W - Символы, не образующие слов, отрицание предыдущего шаблона
         */
        Pattern patternIncorrectLoginSymbol = Pattern.compile("\\W+");
        Matcher matcherIncorrectLoginSymbol = patternIncorrectLoginSymbol.matcher(login);

        Pattern patternIncorrectPasswordSymbol = Pattern.compile("\\W+");
        Matcher matcherIncorrectPasswordSymbol = patternIncorrectPasswordSymbol.matcher(password);

        // Проверка логина на недопустимые символы
        if (matcherIncorrectLoginSymbol.find()) {
            throw new WrongLoginException("Incorrect symbol in login!");
        }
        // Проверка логина на превышение длины
        if (login.length() > maxLoginLength) {
            throw new WrongLoginException(String.format("Login length must not be longer than %d symbols", maxLoginLength));
        }

        // Проверка пароля на недопустимые символы
        if (matcherIncorrectPasswordSymbol.find()) {
            throw new WrongPasswordException("Invalid symbol in password!");
        }
        // Проверка пароля на превышение длины
        if (password.length() > maxPasswordLength) {
            throw new WrongPasswordException(String.format("Password length must not be longer than %d symbols", maxPasswordLength));
        }
        // Проверка совпадения пароля и подтверждения пароля
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Confirmation does not match password!");
        }
    }
}
