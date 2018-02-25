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
public class User  extends EntityMetadata implements UserDetails {

    @Column(name = "NAME")
    protected String email;

    @Column(name = "PASSWORD")
    protected String password;

    UserDto dto() {
       return UserDto.builder()
               .email(this.email)
               .id(super.id)
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
