package com.hw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationValidator {

//    final static int maxLoginLength = 20;
//    final static int minLoginLength = 1;
//    final static int maxPasswordLength = 20;
//    final static int minPasswordLength = 1;

    public static void checkInputData(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        checkLogin(login);
        checkPassword(password, confirmPassword);
    }

    private static void checkLogin(String login) throws WrongLoginException {
        /** Создаем шаблон для допустимых символов в логине
         * \w - Символы, соответствующие словам, сокращение от [a-zA-Z_0-9]
         * ^ - начало слова
         * $ - конец слова
         * {1,20} - от 1 до 20 повторений
         */
        Pattern patternLogin = Pattern.compile("^\\w{1,20}$");
        Matcher matcherLogin = patternLogin.matcher(login);
//        Проверка логина на превышение длины
//        if (login.length() > maxLoginLength || login.length() < minLoginLength) {
//            throw new WrongLoginException(String.format("Login length must be longer than %d symbols and must not be longer than %d symbols", minLoginLength, maxLoginLength));
//        }
//        Проверка логина на недопустимые символы
        if (!matcherLogin.find()) {
            throw new WrongLoginException("Incorrect login!");
//            throw new WrongLoginException("Incorrect symbol in login!");
        }
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        /** Создаем шаблон для допустимых символов в логине
         * \w - Символы, соответствующие словам, сокращение от [a-zA-Z_0-9]
         * ^ - начало слова
         * $ - конец слова
         * {1,20} - от 1 до 20 повторений
         */

        Pattern patternPassword = Pattern.compile("^\\w{1,20}$");
        Matcher matcherPassword = patternPassword.matcher(password);
        // Проверка пароля на соответствие длины
//        if (password.length() > maxPasswordLength || password.length() < minPasswordLength) {
//            throw new WrongPasswordException(String.format("Password length must be longer than %d symbols and must not be longer than %d symbols",
//                    minPasswordLength, maxPasswordLength));
//        }
//        Проверка пароля на недопустимые символы
        if (!matcherPassword.find()) {
            throw new WrongPasswordException("Invalid password!");
//            throw new WrongPasswordException("Invalid symbol in password!");
        }
//        Проверка совпадения пароля и подтверждения пароля
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Confirmation does not match password!");
        }
    }
}
