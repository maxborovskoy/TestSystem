package services;

import entity.User;

public interface UserService {

    boolean isAlreadyExists(String username);

    boolean authorizeUser(User user);

    void registerUser(User user);

    User get(long id);

}
