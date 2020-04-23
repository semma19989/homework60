package kg.attractor.homework60.model;


import kg.attractor.homework60.util.Generator;
import kg.attractor.homework60.util.SecurityConfig;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Document(collection = "userList")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@Builder
public class Users implements UserDetails {
    @Id
    private String id;
    private String name;
    private String login;
    private String mail;
    private String pass;
    public static Users random() {
        return builder()
                .mail(Generator.makeEmail())
                .name(Generator.makeName())
                .pass(SecurityConfig.encoder().encode(Generator.makePassword()))
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    public void setPassword(String password) {
        this.pass = SecurityConfig.encoder().encode(password);
    }

    @Override
    public String getUsername() {
        return getMail();
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
        return true;
    }
}