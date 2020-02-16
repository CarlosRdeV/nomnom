package com.carlosrdev.nom35.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlosrdev.nom35.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
