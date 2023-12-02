package com.mascotas.back.security;

import com.mascotas.back.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PrincipalUser implements UserDetails {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static PrincipalUser build(User user) {
        List<GrantedAuthority> authorities = user.getRol().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolName().name()))
                .collect(Collectors.toList());
        return new PrincipalUser(user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastNames() {
        return lastName;
    }

    @Override
    public String getUsername() {
        return email;
    }

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
        return false;
    }
}
