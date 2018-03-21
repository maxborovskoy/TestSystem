package services;

import dao.UserDAO;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final UserDAO userDAO = new UserDAO();

    @Override
    public boolean isAlreadyExists(String username) {
        return userDAO.getAll().stream()
                .anyMatch(someUser -> username.equals(someUser.getName()));
    }

    @Override
    public boolean authorizeUser(User user) {
        return userDAO.getAll().stream()
                .anyMatch(someUser -> user.getName().equals(someUser.getName())
                        && user.getPassword().equals(someUser.getPassword()));
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
