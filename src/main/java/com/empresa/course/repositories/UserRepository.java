package com.empresa.course.repositories;

import com.empresa.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface UserRepository extends JpaRepository<User, Long> {

}
