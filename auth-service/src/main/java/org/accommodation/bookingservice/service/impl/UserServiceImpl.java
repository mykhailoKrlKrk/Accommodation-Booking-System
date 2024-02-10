package org.accommodation.bookingservice.service.impl;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.accommodation.bookingservice.dto.UserRegistrationRequestDto;
import org.accommodation.bookingservice.dto.UserResponseDto;
import org.accommodation.bookingservice.dto.UserUpdateRequestDto;
import org.accommodation.bookingservice.exception.EntityNotFoundException;
import org.accommodation.bookingservice.exception.RegistrationException;
import org.accommodation.bookingservice.mapper.UserMapper;
import org.accommodation.bookingservice.model.Role;
import org.accommodation.bookingservice.model.User;
import org.accommodation.bookingservice.repository.RoleRepository;
import org.accommodation.bookingservice.repository.UserRepository;
import org.accommodation.bookingservice.service.RoleService;
import org.accommodation.bookingservice.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto updateRole(Long id, Role role) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find user by id: " + id));
        roleRepository.save(role);
        user.getRoles().add(role);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto getUserProfile() {
        return userMapper.toDto(getAuthenticatedUser());
    }

    @Override
    public UserResponseDto updateInfo(UserUpdateRequestDto requestDto) {
        User authenticatedUser = getAuthenticatedUser();
        authenticatedUser.setEmail(requestDto.getEmail());
        authenticatedUser.setFirstName(requestDto.getFirstName());
        authenticatedUser.setFirstName(requestDto.getLastName());
        return userMapper.toDto(userRepository.save(authenticatedUser));
    }

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Unable to complete registration");
        }
        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setRoles(Set.of(roleService.getRoleByRoleName(Role.RoleName.CUSTOMER)));
        return userMapper.toDto(userRepository.save(user));
    }

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByEmail(authentication.getName()).orElseThrow(
                () -> new EntityNotFoundException("Can't find user with email: "
                        + authentication.getName()));
    }
}
