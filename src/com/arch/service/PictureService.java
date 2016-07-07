package com.arch.service;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Picture;
import com.arch.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by I331314 on 2016/6/10.
 *
 * @author zhou
 */
public class PictureService {
    private Dao userDao = new DaoImpl();

    public List<Picture> QueryPictureList(String bId) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getAllPicture(conn, bId);

            List<Picture> list = new ArrayList<>();
            while (resultSet.next()) {
                Picture picture = new Picture();
                picture.setId(resultSet.getString(1) != null ? resultSet.getString(1) : "");
                picture.setBuilding_id(resultSet.getString(2) != null ? resultSet.getString(2) : "");
                picture.setName(resultSet.getString(3) != null ? resultSet.getString(3) : "");
                picture.setType(resultSet.getString(4) != null ? resultSet.getString(4) : "");
                picture.setOrigin(resultSet.getString(5) != null ? resultSet.getString(5) : "");
                picture.setDesc(resultSet.getString(6) != null ? resultSet.getString(6) : "");
                picture.setDate(resultSet.getString(7) != null ? resultSet.getString(7) : "");
                picture.setRelative_designer(resultSet.getString(8) != null ? resultSet.getString(8) : "");
                picture.setRelative_org(resultSet.getString(9) != null ? resultSet.getString(9) : "");
                picture.setCreate_time(resultSet.getString(10) != null ? resultSet.getString(10) : "");
                picture.setSize(resultSet.getString(11) != null ? resultSet.getString(11) : "");

                list.add(picture);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Picture QueryPicture(String id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getPicture(conn, id);

            Picture picture = new Picture();
            if (resultSet.next()) {
                picture.setId(resultSet.getString(1) != null ? resultSet.getString(1) : "");
                picture.setBuilding_id(resultSet.getString(2) != null ? resultSet.getString(2) : "");
                picture.setName(resultSet.getString(3) != null ? resultSet.getString(3) : "");
                picture.setType(resultSet.getString(4) != null ? resultSet.getString(4) : "");
                picture.setOrigin(resultSet.getString(5) != null ? resultSet.getString(5) : "");
                picture.setDesc(resultSet.getString(6) != null ? resultSet.getString(6) : "");
                picture.setDate(resultSet.getString(7) != null ? resultSet.getString(7) : "");
                picture.setRelative_designer(resultSet.getString(8) != null ? resultSet.getString(8) : "");
                picture.setRelative_org(resultSet.getString(9) != null ? resultSet.getString(9) : "");
                picture.setCreate_time(resultSet.getString(10) != null ? resultSet.getString(10) : "");
                picture.setSize(resultSet.getString(11) != null ? resultSet.getString(11) : "");
            }

            return picture;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
