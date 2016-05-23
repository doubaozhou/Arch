package com.arch.dao;

import com.arch.entity.Building;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhou on 2016/5/20.
 * @author zhou
 */
public interface Dao {
    /**
     * 获取所有建筑列表
     * @param conn database connection
     * @return 建筑结果集
     * @throws SQLException
     */
    public ResultSet getAllBuilding(Connection conn) throws SQLException;

    /**
     * 查询某一建筑信息
     * @param conn database connection
     * @param id building id
     * @return Building Class
     * @throws SQLException
     */
    public ResultSet getBuilding(Connection conn, String id) throws SQLException;

    /**
     * 插入建筑基本信息
     * @param conn database connection
     * @param building 建筑类
     * @throws SQLException
     */
    public void setBuildingBaseInfo(Connection conn, Building building) throws SQLException;
}
