package com.example.location.locationweb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="location")
public class Location {
    @Id
    int id ;
    @Column
    String code ;
    @Column
    String name ;
    @Column
    String type;
}
