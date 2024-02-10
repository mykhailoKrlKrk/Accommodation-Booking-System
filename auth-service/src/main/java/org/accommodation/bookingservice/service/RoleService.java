package org.accommodation.bookingservice.service;


import org.accommodation.bookingservice.model.Role;

public interface RoleService {
    Role getRoleByRoleName(Role.RoleName roleName);
}
