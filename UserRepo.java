package com.rk8.WebDevAssignment.Repo;

import com.rk8.WebDevAssignment.Models.appUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<appUser,Long> {
    Optional<appUser> findByEmail(String email);
}
