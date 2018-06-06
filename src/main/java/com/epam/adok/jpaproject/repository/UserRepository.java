package com.epam.adok.jpaproject.repository;

import com.epam.adok.jpaproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

}
