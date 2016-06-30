package com.arch.dao;

import com.arch.entity.Building;
import com.arch.entity.Picture;

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
    ResultSet getAllBuilding(Connection conn) throws SQLException;

    /**
     * 查询某一建筑信息
     * @param conn database connection
     * @param id building id
     * @return Building Class
     * @throws SQLException
     */
    ResultSet getBuilding(Connection conn, String id) throws SQLException;

    /**
     * 插入建筑基本信息
     * @param conn database connection
     * @param building 建筑类
     * @throws SQLException
     */
    void insertBuildingBaseInfo(Connection conn, Building building) throws SQLException;

    /**
     * 更新建筑基本信息
     * @param conn connection
     * @param id b_id
     * @param building building
     * @throws SQLException
     */
    void updateBuildingBaseInfo(Connection conn, String id, Building building) throws SQLException;

    /**
     * 查询所有图片信息
     * @param conn connection
     * @return results
     * @throws SQLException
     */
    ResultSet getAllPicture(Connection conn) throws SQLException;

    /**
     * 获取照片
     * @param conn connection
     * @return picture
     * @throws SQLException
     */
    ResultSet getPicture(Connection conn, String id) throws SQLException;

    /**
     * 插入图片信息
     * @param conn connnection
     * @throws SQLException
     */
    void insertPictureInfo(Connection conn, String id, String bId, String name, String time, String size) throws SQLException;

    /**
     * 更新照片信息
     * @param conn connection
     * @param id p_id
     * @param picture pic
     * @throws SQLException
     */
    void updatePictureInfo(Connection conn, String id, Picture picture) throws SQLException;

    /**
     * 测试DAO
     * @param conn database connection
     * @throws SQLException
     */
    ResultSet test(Connection conn) throws SQLException;
}
