package com.group.libraryapp.service.user;


import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request) {
       User user =  userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional
    public List<UserResponse> getUser() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());

    }
    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(IllegalAccessError::new);
        user.updateName(request.getName());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name) {

        if (userRepository.existsByName(name)) {
            throw new IllegalArgumentException();
        }
        User user = userRepository.findByName(name).orElseThrow(IllegalAccessError::new);
        userRepository.delete(user);
    }


}
