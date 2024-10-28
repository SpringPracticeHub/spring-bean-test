package com.test.HappyTest.service;

import com.test.HappyTest.dto.UserDto;
import com.test.HappyTest.entity.User;
import com.test.HappyTest.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        return UserDto.fromEntity(user);
    }

    public UserDto createUser(UserDto userDto) {
        User user = userDto.toEntity();
        user = userRepository.save(user);
        return UserDto.fromEntity(user);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return UserDto.fromEntity(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
