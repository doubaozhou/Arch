package com.arch.service;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Video;
import com.arch.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2016/7/1.
 * @author zhou
 */
public class VideoService {
    private Dao userDao = new DaoImpl();

    public List<Video> QueryVideoList(String bId) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getAllVideo(conn, bId);

            List<Video> list = new ArrayList<>();
            while (resultSet.next()) {
                Video video = new Video();
                video.setId(resultSet.getString(1) != null ? resultSet.getString(1) : "");
                video.setBuilding_id(resultSet.getString(2) != null ? resultSet.getString(2) : "");
                video.setName(resultSet.getString(3) != null ? resultSet.getString(3) : "");
                video.setDesc(resultSet.getString(4) != null ? resultSet.getString(4) : "");
                video.setDate(resultSet.getString(5) != null ? resultSet.getString(5) : "");
                video.setOwner(resultSet.getString(6) != null ? resultSet.getString(6) : "");
                video.setKey_word(resultSet.getString(7) != null ? resultSet.getString(7) : "");
                video.setCreate_time(resultSet.getString(8) != null ? resultSet.getString(8) : "");
                video.setSize(resultSet.getString(9) != null ? resultSet.getString(9) : "");
                list.add(video);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Video QueryVideo(String id) {
        Connection conn;

        try {
            conn = ConnectionFactory.getConnection();
            ResultSet resultSet = userDao.getVideo(conn, id);

            Video video = new Video();
            if (resultSet.next()) {
                video.setId(resultSet.getString(1) != null ? resultSet.getString(1) : "");
                video.setBuilding_id(resultSet.getString(2) != null ? resultSet.getString(2) : "");
                video.setName(resultSet.getString(3) != null ? resultSet.getString(3) : "");
                video.setDesc(resultSet.getString(4) != null ? resultSet.getString(4) : "");
                video.setDate(resultSet.getString(5) != null ? resultSet.getString(5) : "");
                video.setOwner(resultSet.getString(6) != null ? resultSet.getString(6) : "");
                video.setKey_word(resultSet.getString(7) != null ? resultSet.getString(7) : "");
                video.setCreate_time(resultSet.getString(8) != null ? resultSet.getString(8) : "");
                video.setSize(resultSet.getString(9) != null ? resultSet.getString(9) : "");
            }

            return  video;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
