package kz.kopanitsa.repository;

import kz.kopanitsa.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomUserRepository extends
        JpaRepository<CustomUser, Long>,
        JpaSpecificationExecutor<CustomUser> {

    List<CustomUser> findByName(String name);

    List<CustomUser> findByCity(String city);

    List<CustomUser> findByPhone(String phone);

    Optional<CustomUser> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    @Query("SELECT u FROM CustomUser u JOIN u.roles r WHERE r.name = :roleName")
    List<CustomUser> findByRoleName(@Param("roleName") String roleName);
}
