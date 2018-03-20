package services;

import dao.UserDAO;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final UserDAO userDao = new UserDAO();

    @Override
    public boolean isAlreadyExists(String username) {
        List<User> allUsers = userDao.getAll();

        Optional<User> existingUser = allUsers.stream()
                .filter(someUser -> username.equals(someUser.getName()))
                .findAny();

        return existingUser.isPresent();
    }

    @Override
    public boolean authorizeUser(User user) {
        return true;
    }

    @Override
    public void registerUser(User user) {
        userDao.add(user);
    }

    @Override
    public User get(long id) {
        return userDao.get(id);
    }


}
