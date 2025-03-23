package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository UserJdbcRepository) {
        this.userJdbcRepository =  UserJdbcRepository;
    }

    // 사용자 저장하기
    public void saveUser(UserCreateRequest request) {
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    // 사용자 불러오기
    public List<UserResponse> getUser() {
        return userJdbcRepository.getUser();
    }

    // 사용자 수정하기
    public void updateUser(UserUpdateRequest request) {

        if (userJdbcRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    // 사용자 삭제하기
    public void deleteUser(String userName) {

        if (userJdbcRepository.isUserNotExist(userName)) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.deleteUser(userName);
    }

}
