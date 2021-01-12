package com.emse.spring.faircorp.model;

public class HeaterDto {
    private Long id;
    private String name;
    private long power;
    private WindowStatus windowStatus;
    private String roomName;
    private Long roomId;

    public HeaterDto(Heater heater) {}

    public HeaterDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.windowStatus = window.getWindowStatus();
        this.roomName = window.getRoom().getName();
        this.roomId = window.getRoom().getId();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public long getPower() { return power; }

    public void setPower(long power) { this.power = power; }

    public WindowStatus getHeaterStatus() { return windowStatus; }

    public void setHeaterStatus(WindowStatus windowStatus) { this.windowStatus = windowStatus; }

    public String getRoomName() { return roomName; }

    public void setRoomName(String roomName) { this.roomName = roomName; }

    public Long getRoomId() { return roomId; }

    public void setRoomId(Long roomId) { this.roomId = roomId; }
}
