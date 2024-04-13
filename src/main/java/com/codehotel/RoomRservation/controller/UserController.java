package com.codehotel.RoomRservation.controller;


import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.codehotel.RoomRservation.DTO.UserDTO;
import com.codehotel.RoomRservation.model.User;
import com.codehotel.RoomRservation.services.UserService;
import io.swagger.annotations.*;




@RestController
@RequestMapping("/api/users")
@Api(tags = "User Management")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @ApiOperation("Register a new user")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "User registered successfully"),
        @ApiResponse(code = 400, message = "Invalid request body")
    })

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User registeredUser = userService.register(userDTO);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
    
    
    @ApiOperation("Login user")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Login successful"),
        @ApiResponse(code = 400, message = "Invalid request body"),
        @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        // Vérifier si l'email et le mot de passe sont fournis
        if (!loginRequest.containsKey("email") || !loginRequest.containsKey("password")) {
            return ResponseEntity.badRequest().body("L'email et le mot de passe sont requis");
        }
        // Authentifier l'utilisateur
        User user = userService.login(loginRequest.get("email"), loginRequest.get("password"));

        // Vérifier si l'authentification a réussi
        if (user != null) {
            return ResponseEntity.ok("Connexion réussie"); // Retourner un message de succès
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect"); // Retourner un message d'erreur
        }
    }

    
    @ApiOperation("Update user information")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User information updated successfully"),
        @ApiResponse(code = 404, message = "User not found")
    })  
@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/edituser/{email}")
public ResponseEntity<?> updateUser(@PathVariable String email, @RequestBody UserDTO userDTO) {
    try {
        // Appeler le service pour mettre à jour les informations de l'utilisateur
        User updatedUser = userService.updateUser(email, userDTO);
        return ResponseEntity.ok("Informations personnelles mises à jour avec succès pour l'utilisateur avec l'email : " + email);
    } catch (NoSuchElementException e) {
        // Gérer le cas où aucun utilisateur n'est trouvé avec cet e-mail
        return ResponseEntity.notFound().build();
    }
}

    
    @ApiOperation("Get all users")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "List of all users")
    })
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/allUser")
public List<User> getAllUsers() {
    return userService.getAllUsers();
}



    
    
    @ApiOperation("Delete user")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "User deleted successfully"),
        @ApiResponse(code = 404, message = "User not found")
    })

@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/delete/{email}")
public ResponseEntity<String> deleteUser(@PathVariable String email) {
    boolean deleted = userService.deleteUser(email);
    if (deleted) {
        return ResponseEntity.ok("L'utilisateur avec l'e-mail  a été supprimé avec succès.");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'utilisateur  n'a pas été trouvé ou n'a pas pu être supprimé.");
    }
}


    
    
    

@ApiOperation("Assign role to user")
@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Role assigned successfully"),
    @ApiResponse(code = 404, message = "User not found")
})
@PreAuthorize("hasRole('ADMIN')")
@PostMapping("/{email}/assignRole")
public User assignRole(@PathVariable String email, @RequestParam String role) {
    return userService.assignRole(email, role);
}




}
