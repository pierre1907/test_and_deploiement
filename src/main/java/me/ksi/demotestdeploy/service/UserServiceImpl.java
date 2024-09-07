package me.ksi.demotestdeploy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import me.ksi.demotestdeploy.entity.User;


@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>(
            List.of(new User(1L, "Jordane", "john@doe.com", "123456"),
                    new User(2L, "Jane", "jane@doe.com", "123456"),
                    new User(3L, "Bob", "bob@doe.com", "123456"))
    );

    private long idCounter = 4;  // Commence à 4 puisque 1, 2, et 3 sont déjà utilisés

    /**
     * @param user
     * @return User
     */
    @Override
    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(idCounter++);  // Attribue un ID unique incrémental
        }
        users.add(user);
        return user;
    }

    /**
     * @param id
     * @return User
     */
    @Override
    public User fetchUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * @return
     */
    @Override
    public List<User> findAllUsers() {
        return users;
    }
}