package com.prueba.prueba.user.repository;

import com.prueba.prueba.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Boolean existsByUserName(String userName);

    List<User> findAllByUserActiveTrue();

    User getByUserId(UUID userId);
}
