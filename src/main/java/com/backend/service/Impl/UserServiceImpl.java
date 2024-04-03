package com.backend.service.Impl;


import org.modelmapper.ModelMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.backend.dto.UserDto;
import com.backend.entity.User;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.UserRepo;
import com.backend.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
	private PasswordEncoder passwordEncoder;


    @Override
    public UserDto createUser(UserDto userDto) {




        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {



        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setMobileNumber(userDto.getMobileNumber()); // Fixed typo here
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setAddress(userDto.getAddress());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        User updatedUser = this.userRepo.save(user);
        UserDto savedUser = this.userToDto(updatedUser);
        return savedUser;
    }

    @Override
    public List<UserDto> getAllUsers() {




        List<User> userList = this.userRepo.findAll();
        List<UserDto> userListDto = userList.stream().map(this::userToDto).collect(Collectors.toList());
        return userListDto;
    }

    @Override
    public UserDto getUserById(Long id) {



        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        return this.userToDto(user);
    }

    @Override
    public String deleteUser(Long id) {


        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        this.userRepo.delete(user);
        return "The user is deleted successfully";
    }

    public UserDto userToDto(User user) {



        return this.modelMapper.map(user, UserDto.class);
    }

    public User dtoToUser(UserDto userDto) {


        return this.modelMapper.map(userDto, User.class);
    }

	@Override
	public UserDto registerNewUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

		// encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));


	

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);}
	}
