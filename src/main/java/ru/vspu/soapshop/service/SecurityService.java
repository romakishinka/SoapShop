package ru.vspu.soapshop.service;

/**
 * Created by Roman Kishinka on 18.05.2021.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
