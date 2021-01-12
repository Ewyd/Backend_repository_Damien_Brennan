package com.emse.spring.faircorp.model;

public class BuildingDto {

    private final Long id;
    private final String name;

    public BuildingDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
    }

    public Long getId() { return id;}

    public String getName() { return name;}
}
