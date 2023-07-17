package com.filipeloesch.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipeloesch.application.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
