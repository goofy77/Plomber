package com.plomber.user;

import com.plomber.infrastructure.EntityMetadata;
import com.plomber.user.dto.UserDto;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "USER")
@Entity
@Immutable
@Builder
@NoArgsConstructor
@AllArgsConstructor
class User extends EntityMetadata implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected Integer id;

    @Column(name = "NAME")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    UserDto dto() {
       return UserDto.builder()
               .id(this.id)
               .email(this.email)
               .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return String.valueOf(this.id);
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
