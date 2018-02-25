package com.plomber.defect;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "DEFECT")
public class Defect {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DRAWING_ID")
    private Integer drawingId;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "POSITION_X", nullable = false)
    private Float positionX;

    @Column(name = "POSITION_Y", nullable = false)
    private Float positionY;
}
