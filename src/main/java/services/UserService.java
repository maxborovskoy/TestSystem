package services;

import entity.User;

public interface UserService {

    boolean isAlreadyExists(User user);

    boolean authorizeUser(User user);

    void registerUser(User user);

    User get(long id);

}
