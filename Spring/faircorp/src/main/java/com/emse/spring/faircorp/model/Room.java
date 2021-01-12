package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private Integer floor;

    @Column(nullable=false, length=255)
    private String name;

    @Column
    private Double current_Temperature;

    @Column
    private Double target_Temperature;

    @OneToMany(mappedBy = "room")
    private List<Heater> heater;

    @OneToMany(mappedBy = "room")
    private List<Window> window;

    @ManyToOne
    private Building building;

    public Room() {}

    public Room(Integer floor, String name,Building building) {
        this.floor = floor;
        this.name = name;
        this.building = building;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getCurrent_temperature() { return current_Temperature; }
    public void setCurrent_temperature(Double current_temperature) { this.current_Temperature = current_temperature; }

    public Double getTarget_temperature() { return target_Temperature; }
    public void setTarget_temperature(Double target_temperature) { this.target_Temperature = target_temperature; }

    public List<Heater> getHeaters() { return heater; }
    public void setHeaters(List<Heater> heaters) { this.heater = heaters; }

    public List<Window> getWindows() { return window; }
    public void setWindows(List<Window> windows) { this.window = windows; }

    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building=building; }

}