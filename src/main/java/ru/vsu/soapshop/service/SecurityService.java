package ru.vsu.soapshop.service;

/**
 * Created by Александр on 18.05.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
