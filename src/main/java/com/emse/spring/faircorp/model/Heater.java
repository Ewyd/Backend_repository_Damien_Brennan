package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
public class Heater {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long power;

    @Column(nullable = false)
    private Room room;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus status;

    public Heater(String name, Room room, WindowStatus heaterStatus, long power) {
    }

    public Heater(String name, long power, HeaterStatus status, Room room) {
        this.name = name;
        this.power = power;
        this.status = status;
        this.room = room;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getStatus() {
        return status;
    }

    public void setStatus(HeaterStatus status) {
        this.status = status;
    }

    public Room getRoom() { return room;}
}