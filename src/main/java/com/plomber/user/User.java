package com.plomber.user;

import com.plomber.project.Project;
import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Immutable
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String email;

    @OneToMany
    @JoinColumn(name = "USER_ID", nullable = false)
    private Set<Project> projectEntities;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Set<Project> getProjectEntities() {
        return projectEntities;
    }

}
