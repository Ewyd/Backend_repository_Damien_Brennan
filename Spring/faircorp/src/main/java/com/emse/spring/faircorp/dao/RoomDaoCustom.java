package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface RoomDaoCustom {
    Room FindRoomByName(String name);
    List<Room> FindRoomByBuilding(Building building);
}
