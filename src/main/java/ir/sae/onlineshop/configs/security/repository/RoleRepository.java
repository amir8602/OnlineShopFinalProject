package ir.sae.onlineshop.configs.security.repository;


import ir.sae.onlineshop.configs.security.models.ERole;
import ir.sae.onlineshop.configs.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
