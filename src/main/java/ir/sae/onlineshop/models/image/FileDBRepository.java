package ir.sae.onlineshop.models.image;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {
}