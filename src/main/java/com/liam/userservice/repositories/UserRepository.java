package com.liam.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.liam.userservice.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {





	User findByUserId(Long userId);



}
