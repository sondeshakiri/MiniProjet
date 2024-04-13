package com.codehotel.RoomRservation.services;
import java.util.List;

import com.codehotel.RoomRservation.DTO.UserDTO;
import com.codehotel.RoomRservation.model.User;
public interface UserService {
	User register(UserDTO userDTO);
    User login(String email, String password);
    User updateUser(String email, UserDTO userDTO);

    boolean hasRole(String email, String role);
   
    List<User> getAllUsers();
    boolean deleteUser(String email);
    User assignRole(String email, String role);
   
}
