package com.plomber.user;

import com.plomber.project.Project;
import com.plomber.user.dto.UserDto;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "USER")
@Entity
@Immutable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected Integer id;

    @Column(name = "NAME", nullable = false)
    protected String email;

    @Column(name = "NAME", nullable = false)
    protected String password;

    @OneToMany
    @JoinColumn(name = "USER_ID")
    protected Set<Project> projects;

    UserDto dto() {
       return UserDto.builder()
               .email(this.email)
               .id(this.id)
               .projects(this.projects)
               .build();
    }

}
