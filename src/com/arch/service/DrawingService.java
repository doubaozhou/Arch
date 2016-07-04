package com.arch.service;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Drawing;
import com.arch.entity.Video;
import com.arch.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2016/7/4.
 * @author zhou
 */
public class DrawingService {
    Dao userDao = new DaoImpl();

    public List<Drawing> QueryDrawingList() {
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getAllDrawing(conn);

            List<Drawing> list = new ArrayList<>();
            while (resultSet.next()) {
                Drawing drawing = new Drawing();
                drawing.setId(resultSet.getString(1) != null ? resultSet.getString(1) : "");
                drawing.setBuilding_id(resultSet.getString(2) != null ? resultSet.getString(2) : "");
                drawing.setName(resultSet.getString(3) != null ? resultSet.getString(3) : "");
                drawing.setDesc(resultSet.getString(4) != null ? resultSet.getString(4) : "");
                drawing.setOwner(resultSet.getString(5) != null ? resultSet.getString(5) : "");
                drawing.setCreate_time(resultSet.getString(6) != null ? resultSet.getString(6) : "");
                drawing.setSize(resultSet.getString(7) != null ? resultSet.getString(7) : "");
                list.add(drawing);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Drawing QueryDrawing(String id) {
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getDrawing(conn, id);

            Drawing drawing = new Drawing();
            if (resultSet.next()) {
                drawing.setId(resultSet.getString(1) != null ? resultSet.getString(1) : "");
                drawing.setBuilding_id(resultSet.getString(2) != null ? resultSet.getString(2) : "");
                drawing.setName(resultSet.getString(3) != null ? resultSet.getString(3) : "");
                drawing.setDesc(resultSet.getString(4) != null ? resultSet.getString(4) : "");
                drawing.setOwner(resultSet.getString(5) != null ? resultSet.getString(5) : "");
                drawing.setCreate_time(resultSet.getString(6) != null ? resultSet.getString(6) : "");
                drawing.setSize(resultSet.getString(7) != null ? resultSet.getString(7) : "");
            }

            return drawing;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
