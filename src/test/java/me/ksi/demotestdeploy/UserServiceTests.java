package me.ksi.demotestdeploy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.ksi.demotestdeploy.entity.User;
import me.ksi.demotestdeploy.service.UserServiceImpl;

class UserServiceTests {

    private  UserServiceImpl userService ;

    @BeforeEach
    public void setUp(){
        userService = new UserServiceImpl();
    }

    @Test
    public void testAddUser(){
    User testUser = new User(null, "Stephane", "Stephane@doe.com", "123456");
    User userSaved = userService.saveUser(testUser);
    Assertions.assertAll(
        () -> Assertions.assertNotNull(userSaved.getId()),
        () -> Assertions.assertEquals("Stephane", userSaved.getName()),
        () -> Assertions.assertEquals("Stephane@doe.com", userSaved.getAdresse()),
        () -> Assertions.assertEquals("123456", userSaved.getPassword())
    );
}

    @Test
    public  void findByIdNotFound(){
        Assertions.assertThrows(
                RuntimeException.class, ()-> userService.fetchUserById(10000L)
        );
    }




}
