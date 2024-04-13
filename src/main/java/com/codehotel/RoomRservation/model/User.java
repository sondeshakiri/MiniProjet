package com.codehotel.RoomRservation.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class User implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private int idUser;
    private String name;
    private String SurName;
    private String tel;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Reservation> reservation;

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(long id, int idUser, String name, String surName, String tel, String email, String password,
                String role, List<Reservation> reservation) {
        super();
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        SurName = surName;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.role = role;
        this.reservation = reservation;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Implémentez les méthodes de l'interface UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convertissez le rôle en liste de GrantedAuthority
        return Collections.singletonList(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Vous pouvez implémenter la logique de vérification ici
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Vous pouvez implémenter la logique de vérification ici
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Vous pouvez implémenter la logique de vérification ici
    }

    @Override
    public boolean isEnabled() {
        return true; // Vous pouvez implémenter la logique de vérification ici
    }
}
