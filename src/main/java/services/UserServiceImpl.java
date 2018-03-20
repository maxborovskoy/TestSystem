package services;

import dao.UserDAO;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final UserDAO userDAO = new UserDAO();

    @Override
    public boolean isAlreadyExists(String username) {
        List<User> allUsers = userDAO.getAll();

        Optional<User> existingUser = allUsers.stream()
                .filter(someUser -> username.equals(someUser.getName()))
                .findAny();

        return existingUser.isPresent();
    }

    @Override
    public boolean authorizeUser(User user) {
        List<User> userList = userDAO.getAll();

        for (User u : userList) {
            if(user.getName().equals(u.getName()) && user.getPassword().equals(u.getPassword())) {
                return true;
            }
        }
        return false;
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
