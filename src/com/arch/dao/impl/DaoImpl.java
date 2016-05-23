package com.arch.dao.impl;

import com.arch.dao.Dao;
import com.arch.entity.Building;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhou on 2016/5/20.
 *
 * @author zhou
 */
public class DaoImpl implements Dao {
    @Override
    public ResultSet getAllBuilding(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_HistoricalBuilding");
        return ps.executeQuery();
    }

    @Override
    public ResultSet getBuilding(Connection conn, String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HC_HistoricalBuilding b WHERE b.BUILDINGNUMBER = ?");
        ps.setString(1, id);

        return ps.executeQuery();
    }

    @Override
    public void setBuildingBaseInfo(Connection conn, Building building) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HC_HistoricalBuilding(BUILDINGNAME,CITY,ADDRESS,DESIGNER,BUILDINGDATE," +
                "CONSTRUCTIONORG,DESCRIPTION,TYPE,STYLE,STRUCTURE,POSTCODE,CREATETIME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, building.getName());
        ps.setString(2, building.getCity());
        ps.setString(3, building.getAddress());
        ps.setString(4, building.getDesigner());
        ps.setString(5, building.getDate());
        ps.setString(6, building.getConstruct_org());
        ps.setString(7, building.getDesc());
        ps.setString(8, building.getType());
        ps.setString(9, building.getStyle());
        ps.setString(10, building.getStructure());
        ps.setString(11, building.getPost_code());
        ps.setString(12, building.getCreate_time());

        ps.execute();
    }
}
