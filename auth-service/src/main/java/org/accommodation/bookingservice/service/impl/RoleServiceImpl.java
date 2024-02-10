package org.accommodation.bookingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.accommodation.bookingservice.model.Role;
import org.accommodation.bookingservice.repository.RoleRepository;
import org.accommodation.bookingservice.service.RoleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByRoleName(Role.RoleName roleName) {
        return roleRepository.findRoleByRoleName(roleName).orElseThrow(
                () -> new RuntimeException("Can't find role by role name:" + roleName));
    }
}
