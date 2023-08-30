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
            } catch (WrongLoginException e) {
                throw new RuntimeException(e);
                //System.out.println(e);
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
                //System.out.println(e);
            }
        //}
    }

    public static void checkInputData(String login, String password, String confirmPassword) {
        // Создаем шаблон для недопустимого символа в логине или пароле
        Pattern pattern = Pattern.compile("\\W+");
        Matcher matcherLogin = pattern.matcher(login);
        Matcher matcherPassword = pattern.matcher(password);

        // Проверка логина на недопустимые символы и превышение длины
        if (matcherLogin.find() || login.length() > 20) {
            throw new WrongLoginException("Incorrect login!");
        }

        // Проверка пароля на недопустимые символы и превышение длины
        if (matcherPassword.find() || password.length() > 20) {
            throw new WrongPasswordException("Incorrect password!");
        }

        // Проверка совпадения пароля и подтверждения пароля
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Confirmation does not match password!");
        }
    }
}
