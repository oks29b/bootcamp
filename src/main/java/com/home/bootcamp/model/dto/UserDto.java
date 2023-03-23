package com.home.bootcamp.model.dto;

import com.home.bootcamp.model.entity.Role;
import com.home.bootcamp.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author Oksana Borisenko
 *
 * Purpose: to convert User to UserDto
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String fio;
    private String email;
    private Set<Role> role;

    public UserDto(User user){
        if(user == null){
            throw new IllegalArgumentException("User doesn't exist");
        }else {
            this.fio = user.getSurname() + " " + user.getUsername() + " " + user.getPatronymic();
            this.email = user.getEmail();
            this.role = user.getRole();
        }
    }

    /**
     * A method allow you to convert User to UserDto.
     */
    public void convertUserToUserDto(User user){
        if(user == null){
            throw new IllegalArgumentException("User doesn't exist");
        }else {
            this.fio = user.getSurname() + " " + user.getUsername() + " " + user.getPatronymic();
            this.email = user.getEmail();
            this.role = user.getRole();
        }
    }
}
