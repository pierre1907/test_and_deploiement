package me.ksi.demotestdeploy.service;

import java.util.List;

import me.ksi.demotestdeploy.entity.User;

public interface UserService {
      User saveUser(User user) ;
      User fetchUserById(Long id);
      List<User> findAllUsers();
      

}
