package com.emse.spring.faircorp.model;;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "building")
    private Set<Room> room;

    public Building() {}

    public Building(String name) {
        this.name  = name;
    }

    public Long getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

}
