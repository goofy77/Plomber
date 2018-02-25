package com.plomber.infrastructure;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class EntityMetadata {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected Integer id;

    @Column(name = "CREATED_AT")
    protected LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    protected LocalDateTime updatedAt;

}
