package com.blue.water.service;

import com.blue.water.dto.request.UserCreateRequest;
import com.blue.water.dto.request.UserUpdateRequest;
import com.blue.water.dto.response.UserResponse;
import com.blue.water.exception.EntityAlreadyExistException;
import com.blue.water.mapper.UserMapper;
import com.blue.water.model.User;
import com.blue.water.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public Long create(UserCreateRequest userCreateRequest) {
        if(userRepository.findByEmail(userCreateRequest.email()).isPresent()) {
            throw new EntityAlreadyExistException("User already exist");
        }
        User user = userMapper.toUser(userCreateRequest);
        return userRepository.save(user).getId();
    }

    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User wasn't found"));
        return userMapper.toResponse(user);
    }

    public UserResponse updateById(Long id, UserUpdateRequest userUpdateRequest) {
        User storedUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User wasn't found"));
        User user = userMapper.toUser(userUpdateRequest, storedUser);
        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
