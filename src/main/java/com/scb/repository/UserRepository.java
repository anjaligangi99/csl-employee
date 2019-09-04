package com.scb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
