package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository =  userRepository;
    }

    // 사용자 저장하기
    public void saveUser(UserCreateRequest request) {
        userRepository.saveUser(request.getName(), request.getAge());
    }

    // 사용자 불러오기
    public List<UserResponse> getUser() {
        return userRepository.getUser();
    }

    // 사용자 수정하기
    public void updateUser(UserUpdateRequest request) {

        if (userRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUserName(request.getName(), request.getId());
    }

    // 사용자 삭제하기
    public void deleteUser(String userName) {

        if (userRepository.isUserNotExist(userName)) {
            throw new IllegalArgumentException();
        }

        userRepository.deleteUser(userName);
    }

}
