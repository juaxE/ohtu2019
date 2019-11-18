package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        if (username.length() < 3 || password.length() < 8){
            System.out.println("pituus");
            return true;
        }

        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if ((!(ch >= 'A' && ch <= 'Z'))
                    && (!(ch >= 'a' && ch <= 'z'))) {
                System.out.println("nimi");
                return true;
            }
        }
        boolean muutakin = true;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (((ch >= 'A' && ch <= 'Z'))
                    || ((ch >= 'a' && ch <= 'z'))) {
            }else {
                    muutakin = false;
            }
        }

        return muutakin;
    }
}
