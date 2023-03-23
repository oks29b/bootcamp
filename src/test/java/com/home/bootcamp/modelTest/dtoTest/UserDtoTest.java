package com.home.bootcamp.modelTest.dtoTest;

import com.home.bootcamp.model.dto.UserDto;
import com.home.bootcamp.model.entity.Role;
import com.home.bootcamp.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

public class UserDtoTest {
    @Test
    public void testConstructor() {
        // Create a new user
        User user = new User();
        user.setSurname("Doe");
        user.setUsername("John");
        user.setPatronymic("J.");
        user.setEmail("john.doe@example.com");
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMINISTRATOR);
        user.setRole(roles);

        // Create a new UserDto using the constructor
        UserDto userDto = new UserDto(user);

        // Verify that the UserDto was created correctly
        Assert.assertEquals(userDto.getFio(), "Doe John J.");
        Assert.assertEquals(userDto.getEmail(), "john.doe@example.com");
        Assert.assertEquals(userDto.getRole(), roles);
    }

    @Test
    public void testConvertUserToUserDto() {
        // Create a new user
        User user = new User();
        user.setSurname("Doe");
        user.setUsername("John");
        user.setPatronymic("J.");
        user.setEmail("john.doe@example.com");
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMINISTRATOR);
        user.setRole(roles);

        // Create a new UserDto
        UserDto userDto = new UserDto();

        // Convert the user to a UserDto
        userDto.convertUserToUserDto(user);

        // Verify that the UserDto was created correctly
        Assert.assertEquals(userDto.getFio(), "Doe John J.");
        Assert.assertEquals(userDto.getEmail(), "john.doe@example.com");
        Assert.assertEquals(userDto.getRole(), roles);
    }

    @Test
    public void testConstructorWithNullUser() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserDto(null));
    }

    @Test
    public void testConvertUserToUserDtoWithNullUser() {
        UserDto userDto = new UserDto();

        Assertions.assertThrows(IllegalArgumentException.class, () -> userDto.convertUserToUserDto(null));
    }
}
