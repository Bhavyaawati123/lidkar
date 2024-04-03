package com.backend.service;



import java.util.List;

import com.backend.dto.UserDto;



public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    String deleteUser(Long id);

	UserDto registerNewUser(UserDto userDto);
}

