package services;

import models.Users;

public interface UsersServices {
    String yesOrNot(String email, String password, Users users);
}
