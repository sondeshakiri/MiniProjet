package com.codehotel.RoomRservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehotel.RoomRservation.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	boolean existsByEmail(String email);
	 User findByEmail(String email);
	 int deleteByEmail(String email);
}
