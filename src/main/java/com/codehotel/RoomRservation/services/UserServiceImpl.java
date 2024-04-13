package com.codehotel.RoomRservation.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codehotel.RoomRservation.DTO.UserDTO;
import com.codehotel.RoomRservation.model.User;
import com.codehotel.RoomRservation.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;



@Service
public class UserServiceImpl implements UserService  {
	
	
	private UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
	    this.userRepository = userRepository;
	    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	

    
	@Override
	public User register(UserDTO userDTO) {
	    User user = new User();
	    user.setName(userDTO.getName());
	    user.setSurName(userDTO.getSurName());
	    user.setEmail(userDTO.getEmail());
	    user.setTel(userDTO.getTel());

	    
	 // Hacher le mot de passe avant de le stocker dans la base de données
	    String hashedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
	    user.setPassword(hashedPassword);

	    
	    
	    // Générer un identifiant automatique pour l'utilisateur
	    // Et l'associer à idUser
	    user.setIdUser(generateUserId());
	    
	    // Vérifie si l'email se termine par "@admin.com"
	    if (userDTO.getEmail().endsWith("@admin.com")) {
	        user.setRole("ADMIN");
	    } else {
	        user.setRole("USER");
	    }
	    
	    return userRepository.save(user);
	}
	
	
	// Méthode pour générer un identifiant utilisateur unique
	private int generateUserId() {
		 long totalUsers = userRepository.count();
		    
		    // Générez un identifiant unique en ajoutant 1 au nombre total d'utilisateurs
		    return (int) totalUsers + 1;
	}


	@Override
	public User login(String email, String password) {
	    // Récupérer l'utilisateur à partir de l'email
	    User user = userRepository.findByEmail(email);
	    
	    // Vérifier si l'utilisateur existe et si le mot de passe correspond
	    if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
	        return user; // Retourner l'utilisateur si les informations sont correctes
	    } else {
	        return null; // Retourner null si l'utilisateur n'existe pas ou si le mot de passe est incorrect
	    }
	}

	@Override
	public User updateUser(String email, UserDTO userDTO) {
	    // Récupérer l'utilisateur à partir de son e-mail
	    User user = userRepository.findByEmail(email);
	    if (user != null) {
	        // Mettre à jour les informations de l'utilisateur avec les données fournies dans le DTO
	        user.setName(userDTO.getName());
	        user.setSurName(userDTO.getSurName());
	        user.setTel(userDTO.getTel());
	        // Hacher le nouveau mot de passe avant de le stocker dans la base de données
	        String hashedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
	        user.setPassword(hashedPassword);
	        // Enregistrer les modifications dans la base de données
	        return userRepository.save(user);
	    } else {
	        // Gérer le cas où aucun utilisateur n'est trouvé avec cet e-mail
	        throw new NoSuchElementException("Utilisateur non trouvé avec l'email : " + email);
	    }
	}

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public boolean deleteUser(String email) {
        int deleted = userRepository.deleteByEmail(email);
        return deleted > 0;
    }

    @Override
    @Transactional
    public User assignRole(String email, String role) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setRole(role);
            userRepository.save(user);
        }
        return user;
    }

	@Override
	
	public boolean hasRole(String email, String role) {
		 User user = userRepository.findByEmail(email);
	     return user != null && user.getRole().equals(role);
	}




	






}
