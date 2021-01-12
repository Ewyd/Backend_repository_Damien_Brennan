package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

public class BuildingDaoCustomImpl implements BuildingDaoCustom{

    @PersistenceContext
    public EntityManager em;

    public List<Building> findBuildingById(Long id) {
        String jpql = "Select building from Building building where building.id = :value";
        return em.createQuery(jpql, Building.class).setParameter("value",id).getResultList();
    }
    @Override
    public List<Room> findAllBuildingRooms(Long id) {
        String jpql = "select r from Room r where r.building.id=:id";
        return em.createQuery(jpql)
                .setParameter("id", id)
                .getResultList();
    }
}
