
package com.example.exercisejpa.Repository;

import com.example.exercisejpa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface UserRepository extends JpaRepository<User,Integer> {
}