package ir.sae.onlineshop.models.user.dao;


import ir.sae.onlineshop.models.user.UserEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity, Long> {


    UserEntity save(UserEntity entity);

    List<UserEntity> findAll();

    void deleteById(Long aLong);

    Optional<UserEntity> findById(Long aLong);


}
