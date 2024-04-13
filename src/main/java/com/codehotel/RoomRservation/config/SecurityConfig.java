package com.codehotel.RoomRservation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.codehotel.RoomRservation.services.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/api/users/**").permitAll()
            	.antMatchers("/api/Rooms/**").permitAll()
            	.antMatchers("/api/Reservation/**").permitAll()
            	.antMatchers("/api/Hotel/**").permitAll()
            	.antMatchers("/reservations/**").permitAll()
            	.antMatchers("/**").permitAll()
            	.antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Autoriser l'accès à Swagger UI sans authentification
                // Spécifie que les URLs commençant par "/admin/" nécessitent le rôle "ADMIN"
                .antMatchers("/admin/**").hasRole("ADMIN")
                // Spécifie que les URLs commençant par "/user/" nécessitent soit le rôle "ADMIN" soit le rôle "USER"
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                // Spécifie que les URLs "/login" et "/register" sont accessibles à tous
                .antMatchers("/login", "/register").permitAll()
                // Spécifie que toutes les autres requêtes nécessitent une authentification
                .anyRequest().authenticated()
                .and()
            // Configure l'authentification HTTP Basic
            .httpBasic()
                .and()
            // Désactive CSRF pour permettre l'accès depuis Postman
            .csrf().disable()
            .formLogin()
                // Configure l'authentification via un formulaire de connexion et permet à tout le monde d'y accéder
                .permitAll()
                .and()
            .logout()
                // Configure la fonctionnalité de déconnexion et permet à tout le monde d'y accéder
                .permitAll();
    }
}


