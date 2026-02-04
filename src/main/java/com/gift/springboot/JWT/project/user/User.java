package com.gift.springboot.JWT.project.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    //so it fetches the string value of the enum
    @Enumerated(EnumType.STRING)
    private Role role;

//we reference the enum role created
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
//changed to true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
//returned to true
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
//changed to true
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
//changed to true
    @Override
    public boolean isEnabled() {
        return true;
    }
}
