package com.plomber.drawing;


import com.plomber.defect.Defect;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Entity
@Immutable
@Table(name = "DRAWING")
public class Drawing {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DRAWING_URL", nullable = false)
    private String drawingUrl;

    @OneToMany
    @JoinColumn(name = "DRAWING_ID")
    private List<Defect> defects;

    public Drawing(String drawingUrl) {
        this.drawingUrl = drawingUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDrawingUrl() {
        return drawingUrl;
    }

    public List<Defect> getDefects() {
        return defects;
    }
}
