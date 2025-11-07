package com.aptechph.task_management_system.users.services.impl;

import com.aptechph.task_management_system.users.dto.UserRequest;
import com.aptechph.task_management_system.users.dto.UserResponse;
import com.aptechph.task_management_system.users.mapper.UserMapper;
import com.aptechph.task_management_system.users.model.User;
import com.aptechph.task_management_system.users.repository.UserRepository;
import com.aptechph.task_management_system.users.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        User saved = userRepository.save(user);
        return userMapper.toResponse(saved);
    }
}
