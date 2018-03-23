package services.api;

import entity.User;

public interface UserService {

    boolean isAlreadyExists(User user);

    User authorizeUser(String name, String pass);

    void registerUser(User user);

    User get(long id);

}
