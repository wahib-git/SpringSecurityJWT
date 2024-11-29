package org.example.springsecurityjwt.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.springsecurityjwt.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImp implements UserDetails {
    private static final long serialVersionUID = 1L;
    private long id;
    private String username;

    @JsonIgnore
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    public UserDetailsImp(long id, String username, String password, String email, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }
public static UserDetailsImp build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getName().name()))
            .collect(Collectors.toList());
    return new UserDetailsImp(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getPassword(),
            authorities);
}

}
