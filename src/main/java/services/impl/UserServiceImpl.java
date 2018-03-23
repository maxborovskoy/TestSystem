package services.impl;

import dao.UserDAO;
import entity.User;
import services.api.UserService;

public class UserServiceImpl implements UserService {

    private static final UserDAO userDAO = new UserDAO();

    @Override
    public boolean isAlreadyExists(User user) {
        if (userDAO.get(user.getName()) != null) {
            return true;
        }
        return false;
    }

    @Override
    public User authorizeUser(String name, String pass) {
        User u = userDAO.get(name);
        if (u != null && pass.equals(u.getPassword())) {
            return u;
        }
        return null;
    }

    @Override
    public void registerUser(User user) {
        userDAO.add(user);
    }

    @Override
    public User get(long id) {
        return userDAO.get(id);
    }


}
