package com.shashank.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashank.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
