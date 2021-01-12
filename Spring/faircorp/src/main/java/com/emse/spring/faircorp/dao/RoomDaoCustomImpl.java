package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    public EntityManager em;

    @Override
    public Room FindRoomByName(String name) {
        String jpql = "Select room from Room room where room.name = :value";
        return (Room) em.createQuery(jpql, Room.class).setParameter("value",name).getResultList();
    }

    public List<Room> FindRoomById(Long id) {
        String jpql = "Select room from Room room where room.id = :value";
        return em.createQuery(jpql, Room.class).setParameter("value",id).getResultList();
    }

    public List<Room> FindRoomByBuilding(Building building) {
        String jpql = "Select room from Room room where room.building = :value";
        return em.createQuery(jpql, Room.class).setParameter("value", building).getResultList();
    }
}