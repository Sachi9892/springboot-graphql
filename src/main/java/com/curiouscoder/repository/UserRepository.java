package com.curiouscoder.repository;

import com.curiouscoder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer> {

}
