package com.plomber.project;

import com.plomber.drawing.Drawing;
import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Entity
@Immutable
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private List<Drawing> drawings;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Drawing> getDrawings() {
        return drawings;
    }
}
