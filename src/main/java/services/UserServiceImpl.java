package services;

import dao.UserDAO;
import entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAO();

    @Override
    public boolean isAlreadyExists(User user) {
        List<User> userList = userDAO.getAll();

        for (User u : userList) {
            if(user.getName().equals(u.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean authorizeUser(User user) {
        return isAlreadyExists(user) && validatePassword(user);
    }

    @Override
    public boolean registerUser(User user) {
        return true;
    }

    @Override
    public User get(long id) {
        return userDAO.get(id);
    }

    @Override
    public void updateUserPassword(String name, String oldPassword, String newPassword) {

    }

    public boolean validatePassword(User user) {
        List<User> userList = userDAO.getAll();

        for (User u : userList) {
            if(user.getPassword().equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
