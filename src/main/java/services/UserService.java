package services;

import entity.User;

public interface UserService {

    boolean isAlreadyExists(User user);

    boolean authorizeUser(User user);

    boolean registerUser(User user);

    User get(long id);

    void updateUserPassword(String name, String oldPassword, String newPassword);


}
