package com.home.bootcamp.controllerTest;

import com.home.bootcamp.controller.UserController;
import com.home.bootcamp.model.dto.UserDto;
import com.home.bootcamp.model.entity.Role;
import com.home.bootcamp.model.entity.User;
import com.home.bootcamp.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserControllerTest {
    @Test
    public void testAddUser() throws Exception {
        // Create a new user
        User user = new User();
        user.setSurname("Doe");
        user.setUsername("John");
        user.setPatronymic("J.");
        user.setEmail("john.doe@example.com");
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMINISTRATOR);
        user.setRole(roles);

        // Mock the UserRepositoryTest
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Mockito.when(userRepository.save(user)).thenReturn(user);

        // Create the UserController
        UserController userController = new UserController(userRepository);

        // Add the new user
        userController.addUser(user);

        // Verify that the user was added
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void testGetListUsers() throws Exception {
        // Create a new user
        User user = new User();
        user.setSurname("Doe");
        user.setUsername("John");
        user.setPatronymic("J.");
        user.setEmail("john.doe@example.com");
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMINISTRATOR);
        user.setRole(roles);

        // Create a new user
        User user2 = new User();
        user2.setSurname("Doe");
        user2.setUsername("John");
        user2.setPatronymic("J.");
        user2.setEmail("john.doe@example.com");
        Set<Role> roles2 = new HashSet<>();
        roles2.add(Role.SECURE_API_USER);
        user2.setRole(roles2);

        // Create a list of users
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        // Mock the UserRepositoryTest
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Mockito.when(userRepository.findAll()).thenReturn(users);

        // Create the UserController
        UserController userController = new UserController(userRepository);

        // Get the list of all users
        List<UserDto> userDto = userController.getListUsers();

        // Verify that the list of UserDto is not empty
        Assert.assertFalse(userDto.isEmpty());

        // Verify that the UserDto match the users
        Assert.assertEquals(userDto.size(), users.size());
        for (int i = 0; i < userDto.size(); i++) {
            Assert.assertEquals(userDto.get(i).getFio(),
                    users.get(i).getSurname() + " " + users.get(i).getUsername() + " " + users.get(i).getPatronymic());
            Assert.assertEquals(userDto.get(i).getEmail(), users.get(i).getEmail());
            Assert.assertEquals(userDto.get(i).getRole(), users.get(i).getRole());
        }
    }
}
