package org.accommodation.bookingservice.repository;

import java.util.Optional;
import org.accommodation.bookingservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByRoleName(Role.RoleName roleName);
}
