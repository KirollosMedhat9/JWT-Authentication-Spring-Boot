package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name ="users")
@Getter
@Setter
public class User implements UserDetails {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    @Column (unique = true , nullable = false)
    private String name; 

    @Column (unique = true , nullable = false)
    private String email; 

    @Column (nullable = false)
    private String password; 

    private boolean enabled; 

    @Column (name = "verification_code")
    private String verficationCode; 
    
    @Column (name ="verification_expiration")
    private LocalDateTime verificationCodeExpiresAt; 


    public User() {
    }


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection< ? extends GrantedAuthority> getAuthorities(){
        return List.of();
    }

    //TODO: add proper boolean checks
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }


}
