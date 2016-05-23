package com.arch.service;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Building;
import com.arch.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2016/5/20.
 * @author zhou
 */
public class BuildingService {
    private Dao userDao = new DaoImpl();

    public List<Building> QueryBuildingList() {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getAllBuilding(conn);

            List<Building> list = new ArrayList<>();
            while (resultSet.next()) {
                Building building = new Building();
                building.setId(resultSet.getString(1));
                building.setName(resultSet.getString(2));
                building.setCity(resultSet.getString(3));
                building.setAddress(resultSet.getString(4));
                building.setDesigner(resultSet.getString(5));
                building.setDate(resultSet.getString(6));
                building.setConstruct_org(resultSet.getString(7));
                building.setDesc(resultSet.getString(8));
                building.setType(resultSet.getString(9));
                building.setStyle(resultSet.getString(10));
                building.setStructure(resultSet.getString(11));
                building.setPost_code(resultSet.getString(12));
                building.setCreate_time(resultSet.getString(13));

                list.add(building);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Building QueryBuilding(String id) {
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getBuilding(conn, id);
            if (resultSet.next()) {
                Building building = new Building();
                building.setId(resultSet.getString(1));
                building.setName(resultSet.getString(2));
                building.setCity(resultSet.getString(3));
                building.setAddress(resultSet.getString(4));
                building.setDesigner(resultSet.getString(5));
                building.setDate(resultSet.getString(6));
                building.setConstruct_org(resultSet.getString(7));
                building.setDesc(resultSet.getString(8));
                building.setType(resultSet.getString(9));
                building.setStyle(resultSet.getString(10));
                building.setStructure(resultSet.getString(11));
                building.setPost_code(resultSet.getString(12));
                building.setCreate_time(resultSet.getString(13));
                return building;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
