package ir.sae.onlineshop.repositories;


import ir.sae.onlineshop.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    UserEntity save(UserEntity entity);
//    @Modifying
//    @Query(value = "update UserEntity u set u.id", nativeQuery = true)


    List<UserEntity> findAll();

    void deleteById(Long aLong);

    Optional<UserEntity> findById(Long aLong);

    UserEntity getByUsername(String username);


}
