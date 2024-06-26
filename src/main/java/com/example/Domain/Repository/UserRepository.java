package com.example.Domain.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Domain.Model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    @SuppressWarnings("null")
    @Override
    <S extends User> S save(S entity);

}
