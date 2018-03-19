package services;

import entity.User;

public class UserServiceImpl implements UserService {

    @Override
    public boolean isAlreadyExists(User user) {
        return false;
    }

    @Override
    public boolean authorizeUser(User user) {
        return true;
    }

    @Override
    public boolean registerUser(User user) {
        return true;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public void updateUserPassword(String name, String oldPassword, String newPassword) {

    }
}
