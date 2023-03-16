package services.impl;

import models.Users;
import services.UsersServices;

public class UsersServicesImpl implements UsersServices {
    @Override
    public String yesOrNot(String email, String password, Users users) {
        if(email.equalsIgnoreCase(users.getEmail())){
            System.out.println(email+" найден");
            if(password.equalsIgnoreCase(users.getPassword())){
                return "yes";
            }
        }
        return null;
    }
}
